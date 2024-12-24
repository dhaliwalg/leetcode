/**
 * LeetCode: 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Given an unsorted array of integers nums, return the length of the longest 
 * consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * 
 * Example:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. 
 * Therefore its length is 4.
 * 
 *  
 * Brute Force Solution:
 * int result = 0;
 * for(num: nums){
 *  add to HashSet
 * }
 * 
 * for(num: nums){
 *  currNumber = num
 *  streak = 0
 * 
 *  while(hashSet.contains(currNumber)){
 *      currNumber++;
 *      streak++;
 * }
 *  result = Math.max(streak, result);
 * }
 * 
 * return result
 * 
 * Time Complexity: O(n^2) worst case
 * Space Complexity: O(n)
 */

 /*
  * Issues: 
  Treating every single number as a potential starting point
  Gonna do a lot of repeat work this way

  Optimization:
  Only loop numbers that could actually be the start of the seq
  Set cannot have value before it in order for us to loop thru
  */
import java.util.*;
class Solution {
    public int longestConsecutive(int[] nums) {    
        Set<Integer> hashSet = new HashSet<>();
        int result = 0;

        //add everything into the set
        for(int num: nums){
            hashSet.add(num);
        }

        //go thru the numbers, if the set doesn't have the value before it
        //then it can be a sequence starter and we can probe for length of sequence
        for(int num: nums){
            if(!hashSet.contains(num-1)){
                int length = 1;
                while(hashSet.contains(num+length)){
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println("Expected: 4");
        System.out.println("Actual: " + solution.longestConsecutive(nums));
    }
}