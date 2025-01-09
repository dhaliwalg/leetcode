package patterns.two-pointers.solutions;

class Solution {

    boolean someCondition = true;
    int someResult = 0;

    public int someFunction(int[] nums) {
        // Edge cases
        if (nums == null || nums.length == 0) return 0;
        
        // Initialize pointers
        int left = 0;
        int right = nums.length - 1;  // or another position based on problem
        
        // Move pointers
        while (left < right) {
            // Calculate something
            
            // Move pointers based on condition
            if (someCondition) {
                left++;
            } else {
                right--;
            }
        }
        
        return someResult;
    }
}