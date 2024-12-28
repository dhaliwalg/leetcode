import java.util.HashSet;

/**
 * LeetCode Problem: Longest Substring Without Repeating Characters
 * 
 * Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * 
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */

class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        // Initialize the left pointer of our sliding window
        int l = 0;
        
        // Variable to store the length of the longest valid substring found so far
        int longestSubstring = 0;
        
        // HashSet to keep track of characters in current window
        // Using HashSet because it provides O(1) lookup and ensures uniqueness
        HashSet<Character> charSet = new HashSet<>();
        
        // Right pointer 'r' will iterate through the string
        // This creates our sliding window from 'l' to 'r'
        for(int r = 0; r < s.length(); r++) {
            
            // If we find a duplicate character (character at 'r' already exists in our set)
            // we need to shrink our window from the left until we remove that duplicate
            while(charSet.contains(s.charAt(r))) {
                // Remove characters from the left of our window
                charSet.remove(s.charAt(l));
                // Move left pointer to shrink the window
                l++;
            }
            
            // At this point, we're guaranteed that the character at 'r' is not in our set
            // Add the new character to our set
            charSet.add(s.charAt(r));
            
            // Update the longest substring length if current window is longer
            // Current window size is (r - l + 1)
            longestSubstring = Math.max(longestSubstring, r - l + 1);
        }
        
        return longestSubstring;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeating solution = new LongestSubstringWithoutRepeating();
        
        // Test cases
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // Expected output: 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb")); // Expected output: 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // Expected output: 3
        System.out.println(solution.lengthOfLongestSubstring("")); // Expected output: 0
        System.out.println(solution.lengthOfLongestSubstring("au")); // Expected output: 2
    }
}