package patterns.sliding

-window.solutions;

public class template {

    private boolean invalid() {
        return false;
    }

    // NON-SHRINKING WINDOW (Shifts when invalid)
    public int nonShrinkingWindow(int[] nums) {
        int i = 0, j = 0;
        for (; j < nums.length; j++) {
            // Add nums[j] to state

            while (invalid()) {  // Window invalid
                // Remove nums[i] from state
                i++;
            }
            // Window [i,j] might be valid here
        }
        return j - i;  // Max valid window size
    }

// SHRINKING WINDOW (Contracts until valid)
    public int shrinkingWindow(int[] nums) {
        int i = 0, j = 0, maxLen = 0;

        for (; j < nums.length; j++) {
            // Add nums[j] to state

            while (invalid()) {  // Keep shrinking until valid
                // Remove nums[i] from state
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}


// If you need max window that was ever valid (shrinking)
// If you need final valid window size (non-shrinking)