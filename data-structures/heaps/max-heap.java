import java.util.*;

class MaxHeap {
    public void demo() {
        // Method 1: Using reversed comparator
        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>((a, b) -> b - a);
        
        // Method 2: Using Collections.reverseOrder()
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>(Collections.reverseOrder());
        
        // Common operations (same as min heap)
        maxHeap1.offer(3);        // Add element
        maxHeap1.offer(1);
        maxHeap1.offer(2);
        
        int max = maxHeap1.peek(); // Get max without removing (returns 3)
        int removed = maxHeap1.poll(); // Get and remove max (returns 3)
        
        // Converting heap to array
        Object[] array = maxHeap1.toArray();
    }
}
