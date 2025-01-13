import java.util.*;

class MinHeap {
    public void demo() {
        // Method 1: Simple number min heap
        PriorityQueue<Integer> minHeap1 = new PriorityQueue<>();
        
        // Method 2: With initial capacity
        PriorityQueue<Integer> minHeap2 = new PriorityQueue<>(10);
        
        // Method 3: With custom comparator (same as default for numbers)
        PriorityQueue<Integer> minHeap3 = new PriorityQueue<>((a, b) -> a - b);
        
        // Common operations
        minHeap1.offer(3);        // Add element
        minHeap1.offer(1);
        minHeap1.offer(2);
        
        int min = minHeap1.peek(); // Get min without removing (returns 1)
        int removed = minHeap1.poll(); // Get and remove min (returns 1)
        boolean isEmpty = minHeap1.isEmpty(); // Check if empty
        int size = minHeap1.size(); // Get size
    }
}
