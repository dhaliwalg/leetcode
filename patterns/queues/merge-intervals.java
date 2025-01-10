package patterns.queues;

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case check
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        
        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Use ArrayList since we don't know final size
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);
        
        for (int[] interval : intervals) {
            // Get current end from last interval in merged list
            int currentEnd = currentInterval[1];
            
            // If intervals overlap, update the end time
            if (interval[0] <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, interval[1]);
            } else {
                // No overlap, add as new interval
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        
        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }
}

/* Test cases:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
*/