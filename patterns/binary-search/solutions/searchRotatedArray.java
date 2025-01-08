/**Given the rotated sorted array nums and an integer target, 
 * return the index of target within nums, or -1 if it is not present. */

public class searchRotatedArray{
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target) {
                return mid;
            }
            
            // Left side is sorted
            if(nums[left] <= nums[mid]) {
                if(target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;  // target is in the sorted left half
                } else {
                    left = mid + 1;   // target must be in right half
                }
            }
            // Right side is sorted
            else {
                if(target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;   // target is in the sorted right half
                } else {
                    right = mid - 1;  // target must be in left half
                }
            }
        }
        return -1;
    }
}