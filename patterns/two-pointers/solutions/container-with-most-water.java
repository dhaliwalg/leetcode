// Leetcode Problem: Container With Most Water
// Description: Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
// Find two lines, which together with the x-axis forms a container, such that the container contains the most water.
// Note: You may not slant the container and n is at least 2.

class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = 0;
        int maxArea = 0;

        while(l < r){
            int width = (r - l);
            int minHeight = Math.min(height[l], height[r]);

            maxArea = Math.max(maxArea, (minHeight * width));
            if(minHeight == height[l]){
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        
        // Test cases
        int[] heights1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(solution.maxArea(heights1)); // Expected output: 49

        int[] heights2 = {1,1};
        System.out.println(solution.maxArea(heights2)); // Expected output: 1

        int[] heights3 = {4,3,2,1,4};
        System.out.println(solution.maxArea(heights3)); // Expected output: 16

        int[] heights4 = {1,2,1};
        System.out.println(solution.maxArea(heights4)); // Expected output: 2
    }
}