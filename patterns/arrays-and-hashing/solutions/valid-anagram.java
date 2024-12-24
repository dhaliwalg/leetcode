/*
 * Valid Anagram (Leetcode #242)
 * 
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * 
 * Example:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * 
 * Brute Force Approach:
 * We can utilize sorting:
 * public boolean isAnagram(String s, String t){
 *  if(s.length() != t.length()){
 *      return false;
 *  }
 * 
 *  char[] sChars = s.toCharArray();
 *  char[] tChars = t.toCharArray();
 * 
 *  Arrays.sort(sChars);
 *  Arrays.sort(tChars);
 * 
 *  return Array.equals(sChars, tChars);
 * }
 * 
 * Issues:
 * Sorting adds complexity
 * 
 * Optimization:
 * Remove sorting, create a frequency Map to contains the counts per character
 * Compare the Maps
 */

import java.util.*;
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return  false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }

        return sMap.equals(tMap);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case
        String s = "anagram";
        String t = "nagaram";
        
        boolean result = solution.isAnagram(s, t);
        System.out.println("Is '" + s + "' an anagram of '" + t + "'? " + result);
    }
}