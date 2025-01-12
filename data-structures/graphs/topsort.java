import java.util.*;

class TopologicalSort {
    public List<Integer> topoSort(int n, List<List<Integer>> prerequisites) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Create in-degree array (count of incoming edges for each node)
        int[] inDegree = new int[n];
        
        // Build the graph
        for (List<Integer> pre : prerequisites) {
            int from = pre.get(1);
            int to = pre.get(0);
            adj.get(from).add(to);
            inDegree[to]++;
        }
        
        // Add all nodes with 0 in-degree to queue (no prerequisites)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Process nodes level by level
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            result.add(curr);
            
            // Reduce in-degree of neighbors
            for (int next : adj.get(curr)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        // If result size != n, there's a cycle
        return result.size() == n ? result : new ArrayList<>();
    }
}