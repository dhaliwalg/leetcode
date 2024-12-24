/**
 * LeetCode #238 - Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * Given an integer array nums, return an array answer such that answer[i] is equal 
 * to the product of all the elements of nums except nums[i].
 * 
 * Brute Force Method:
 * Double loop, multiply all values except for when i & j are in the same spot
 * int[] results = new int[nums.length]
 * 
 * for(int i = 0; i < nums.length; i++){
 *  int result = 1;
 * 
 *    for(int j = 0; j < nums.length; j++){
 *      if(i != j){
 *       result *= nums[j];
 *    }
 * 
 *  results[i] = result;
 *  }
 *  return results;
 * }
 * 
 * Brute Force Failures:
 * Effectively redoing a bunch of calculations, making it inefficient
 * Prefix/Suffix approach will store the value for us and allow us to access pre-done calcs
 * O(N^2)
 * 
 * Optimize: Prefix/Suffix Array
 */
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = 1;
        suffix[n-1] = 1;

        //Starts at 1, gives the sum of values before i
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }
        //Starts at n-12, gives sum of values after i
        for(int i = n-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        //Combine the two
        for(int i = 0; i < n; i++){
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test Case 1
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.productExceptSelf(nums);
        
        // Expected output: [24, 12, 8, 6]
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}