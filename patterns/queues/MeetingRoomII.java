package patterns.queues;

import java.util.*;

/**
 * Definition of Interval: public class Interval { public int start, end; public
 * Interval(int start, int end) { this.start = start; this.end = end; } }
 */

class MeetingRoomII {

    public int start, end;

    public MeetingRoomII(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {

    public int minMeetingRooms(List<MeetingRoomII> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (MeetingRoomII interval : intervals) {
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }
        return minHeap.size();
    }
}
