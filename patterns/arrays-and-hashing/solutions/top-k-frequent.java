/*
 * LeetCode Problem: Top K Frequent Elements
 * 
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 * 
 * Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * 
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 * 
 * Constraints:
 * - 1 <= nums.length <= 105
 * - -104 <= nums[i] <= 104
 * - k is in the range [1, the number of unique elements in the array]
 * - It is guaranteed that the answer is unique
 * 
 * public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            arr.add(new int[] {entry.getValue(), entry.getKey()});
        }
        arr.sort((a, b) -> b[0] - a[0]);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr.get(i)[1];
        }
        return res;
    }
}
 */
import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for(int num: nums){
            resultMap.put(num, resultMap.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: resultMap.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            bucket[freq].add(num);
        }

        int[] res = new int[k];
        int index = 0;
        //Create result array, then mark the location in the result
        //with index. Start at the end w/ most freq element - go til index = k
        //go thru the bucket at the spot, add it to the result array
        //++ is postfix operator so it'll start at 0
        
        for (int i = bucket.length - 1; i > 0 && index < k; i--) {
            for (int n : bucket[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}