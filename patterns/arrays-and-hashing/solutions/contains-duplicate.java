/*
Problem: Contains Duplicate
Leetcode URL: https://leetcode.com/problems/contains-duplicate/

APPROACH 1: Brute Force
Time: O(n²), Space: O(1)
*/

class BruteForceSolution {
    public boolean containsDuplicate(int[] nums) {
        // TODO: Implement solution
        return false;
    }

class OptimizedSolution {
    public boolean containsDuplicate(int[] nums){
        return false;
    }
}
 
    // Test cases
    public static void main(String[] args) {
        BruteForceSolution solution = new BruteForceSolution();
        
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