/*
 * LeetCode #20 - Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Problem: Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 */
import java.util.*;
 class Solution {
    public boolean validParenthesis(String s){
        //Put closing brackets in the map as the Key, so they map to the openings
        Map<Character, Character> pairMap = new HashMap<>();
        pairMap.put(')', '(');
        pairMap.put('}', '{');
        pairMap.put(']', '[');

        Stack<Character> stack = new Stack<>();

        //Go through chars in the Array, and if it's not a closing bracket
        //then we'll push it into the stack
        for(char c: s.toCharArray()){
            if(!pairMap.containsKey(c)){
                stack.push(c);
            //If it's a closing bracket, our checks are just if its empty of if its NOT the proper closing match
            } else {
                if(stack.isEmpty() || stack.pop() != pairMap.get(c)){
                    return false;
                }
            }
        }

        //if its empty, then all the pairs matched up & we're good
        return stack.isEmpty();
    }
 }