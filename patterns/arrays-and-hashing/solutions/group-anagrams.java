import java.util.*;
    /**
     * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     * 
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, 
     * typically using all the original letters exactly once.
     * 
     * Example:
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 
     * Constraints:
     * - 1 <= strs.length <= 10^4
     * - 0 <= strs[i].length <= 100
     * - strs[i] consists of lowercase English letters.
     * 
     * Brute force method:
     * Still need a lookup table essentially, going to have a Map.
     * Key = sorted string, Value = str
     * 
     * public <List<List<String>> groupAnagrams(String[] strs){
     *  Map<String, <List<String>> resultMap = new HashMap<>();
     * for(String str: strs){
        *  char[] c = str.toCharArray();
        *  Arrays.sort(c);
        *  resultMap.putIfAbsent(c, new ArrayList<>());
        *  resultMap.get(c).add(str);
     * }
     *  return new ArrayList<>(resultMap.values());
     * }
     * 
     * Issues: O(m * n log n) -> log n due to sort. m = number of strings & n = longest string
     * 
     * Optimization: Remove sorting from the equation. 
     * We can use a HashMap/FreqList for the key. 
     * O(mn) -> space complexity is just O(m)
     */
    
class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> resultMap = new HashMap<>();

        for(String str: strs){
            Map<Character, Integer> frqMap = new HashMap<>();

            for(char c: str.toCharArray()){
                frqMap.put(c, frqMap.getOrDefault(c, 0)+1);
            }

            resultMap.putIfAbsent(frqMap, new ArrayList<>());
            resultMap.get(frqMap).add(str);
        }
        return new ArrayList<>(resultMap.values());
    }

    public static void main(String[] args) {
        GroupAnagrams solution = new GroupAnagrams();
        String[] testInput = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(testInput);
        System.out.println(result);
    }
}