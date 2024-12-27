import java.util.*;

/**
 * LeetCode Problem: 3 Sum
 * 
 * Description:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] 
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * 
 * Constraints:
 * - 0 <= nums.length <= 3000
 * - -10^5 <= nums[i] <= 10^5
 */


class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> valueSet = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            for(int j = i +1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(nums[i] + nums[j] + nums[k] == 0){
                        valueSet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return new ArrayList<>(valueSet);
    }

    public static void main(String[] args) {
        ThreeSum solution = new ThreeSum();
        
        // Test cases
        int[] test1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(test1)); // Expected output: [[-1, -1, 2], [-1, 0, 1]]

        int[] test2 = {};
        System.out.println(solution.threeSum(test2)); // Expected output: []

        int[] test3 = {0};
        System.out.println(solution.threeSum(test3)); // Expected output: []
    }
}