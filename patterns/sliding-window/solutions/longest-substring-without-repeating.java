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
        // Your solution goes here
        return 0;
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