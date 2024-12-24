/*
Problem: Contains Duplicate
Leetcode URL: https://leetcode.com/problems/contains-duplicate/

APPROACH 1: Brute Force
Time: O(n²), Space: O(1)

bruteForceApproach:
public boolean containsDuplicate(int[] nums){
    for(int i = 0; i < nums.length; i++){
        for(int j = i + 1; j < nums.length; j++){
            if(nums[i] == nums[j]){
                return true;
            }
        }
    }
    return false;
}

Issues:
O(n^2), repeatedly checking the same values.

Optimization:
Sets don't allow for duplicate values by design. Few ways to approach that:
- Could add values to Set -> lookup if Set contains value already and then return T/F
OR
- Since we can't have duplicates in the Set no matter what, we can just add all the values
- Then compare the length of the original array to the size of the Set
*/
import java.util.*;
class Solution {
   public boolean containsDuplicate(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for(int num: nums){
        set.add(num);
       }

       return set.size() != nums.length;
   }

   // Test cases
   public static void main(String[] args) {
       Solution solution = new Solution();
       
       // Test case 1: Has duplicate
       int[] test1 = {1, 2, 3, 1};
       System.out.println(solution.containsDuplicate(test1)); // Expected: true
       
       // Test case 2: No duplicates
       int[] test2 = {1, 2, 3, 4};
       System.out.println(solution.containsDuplicate(test2)); // Expected: false
       
       // Test case 3: Empty array
       int[] test3 = {};
       System.out.println(solution.containsDuplicate(test3)); // Expected: false
       
       // Test case 4: Single element
       int[] test4 = {1};
       System.out.println(solution.containsDuplicate(test4)); // Expected: false
   }
}