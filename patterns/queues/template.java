package patterns.queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class template {
    public int[][] merge(int[][] intervals) {
    // Edge case
    if (intervals == null || intervals.length <= 1) {
        return intervals;
    }
    
    // Sort by start time//flipping the comparator will make it descending order
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    
    List<int[]> merged = new ArrayList<>();
    int[] currentInterval = intervals[0];
    merged.add(currentInterval);
    
    for (int[] interval : intervals) {
        int currentEnd = currentInterval[1];
        
        if (interval[0] <= currentEnd) {
            currentInterval[1] = Math.max(currentEnd, interval[1]);
        } else {
            currentInterval = interval;
            merged.add(currentInterval);
        }
    }
    
    return merged.toArray(new int[merged.size()][]);
}
}
