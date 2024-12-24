/*
 * LeetCode #1: Two Sum
 * 
 * Problem: Given an array of integers nums and an integer target, return indices of the two numbers 
 * in the array such that they add up to target. You may assume that each input would have exactly 
 * one solution, and you may not use the same element twice.
 * 
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
 * 
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * 
 * Constraints:
 * - Only one valid answer exists
 * 
 * Brute Force:
 * Go through every single index, with a double loop. If the indices match up - then return them
 * 
 * public int[] twoSum(int[] nums, int target){
 *  for(int i = 0; i < nums.length; i++){
 *      for(int j = i +1; j < nums.length; j++){
 *          if(nums[i] + nums[j] == target){
 *              return new int[]{i, j};
 *    }
 *   }
 *  }
 *  return new int[]{0};
 * }
 */

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            int diff = target - num;

            if(hashMap.containsKey(diff)){
                int diffIdx = hashMap.get(diff);
                return new int[]{diffIdx, i};
            }
            hashMap.put(num, i);
        }
        return new int[]{0};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Test Case 1 Output: [" + result[0] + "," + result[1] + "]");
    }
}