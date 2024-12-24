# Arrays & HashMap/HashSet Patterns

## Core Concept
Arrays & Hashing solve problems where you have to determine frequency, map indices to values, or find duplicates.
Hashing gives us O(1) lookup, providing an optimization over brute force O(n^2) looping through the array.

## When to Use
- Need to find duplicates/matches
- Track frequency of elements with HashMap
- Find pairs/groups that satisfy conditions (TwoSum & ContainsDuplicate II)
- Map values to indices
- Find missing/extra elements

## Common Techniques
- HashMap -> value, index mapping
- MashSet -> tracking seen values
- Frequency counter with Map

## Edge Cases to Watch
- Empty array/string
- Single element
- All duplicates
- No matches found
- Negative numbers
- Very large numbers
- Special characters in strings
- Case sensitivity

## Common Problems & Variations
1. Find Duplicates
   1.  Set/Map for O(n)
2. Counting Frequency
   1. Map/Object to count
3. Finding Pairs/Complements
   1. HashMap to store complements
   2. TWO POINTER if sorted
4. String Manipulation
   1. HashMap for frequency/anagrams

## Time/Space Complexity
- Brute Force: O(n^2), O(1) space
- HashMap: O(n), O(n) space

## Problem Notes
- Two Sum: Hunt for compliments
- Anagrams: Frequency count and compare Maps directly