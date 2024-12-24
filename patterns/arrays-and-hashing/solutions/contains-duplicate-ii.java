/**
 * URL: https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * Problem Description:
 * Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
 * 
 * Example:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * 
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * 
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 * 
 * Brute Force Solution:
    public boolean containsNearbyDuplicate(int[] nums, int k){
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] == nums[j] && (j - i) <= k){
                    return true;
                }
            }
        }
        
        return false;
    }

Issues:
O(n^2) due to double looping, constantly checking same pairs

Optimization:
- Hunting for target value of nums[i] - curious to see if it exists or not
- Num needs to have its index, since k is a constraint. So store (num, index) pairs in Map
- Check if Map already has the value (means dup) AND check if the indices are within k
 */

import java.util.*;
class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> resultMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(resultMap.containsKey(num) && i - resultMap.get(num) <= k){
                return true;
            }
            resultMap.put(num, i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII solution = new ContainsDuplicateII();
        int[] nums = {1, 2, 3, 1};
        int k = 2;
        System.out.println(solution.containsNearbyDuplicate(nums, k)); // Expected output: false
    }
}