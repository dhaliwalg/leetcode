# Sliding Window

## Core Concept
The sliding window pattern involves creating a window that slides over the data to solve problems involving contiguous subarrays or substrings.

## When to Use
- Problems involving subarrays or substrings
- Fixed or variable window sizes
- Keywords: "contiguous", "subarray", "substring", "window"

## Common Techniques
- Two-pointer technique
- Expanding and contracting the window
- Maintaining a running sum or count within the window

## Edge Cases to Watch
- Empty arrays/strings
- Single elements
- Overlapping windows
- Window size larger than the array/string

## Common Problems & Variations
- Maximum sum subarray of size k
- Longest substring without repeating characters
- Minimum window substring
- Variations: fixed-size window, dynamic-size window

## Time/Space Complexity
- Typical time complexity: O(n)
- Space complexity: O(1) for fixed-size window, O(n) for dynamic-size window
- Complexity driven by the need to traverse the array/string and maintain window state