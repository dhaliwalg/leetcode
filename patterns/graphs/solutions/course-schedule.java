package patterns.graphs.solutions;
import java.util.*;

class Solution{
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            graph.get(pre[0]).add(pre[1]);
        }
        
        int[] visited = new int[numCourses]; // 0=unvisited, 1=visiting, 2=visited
        
        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(i, graph, visited)) return false;
        }
        return true;
    }
    
    private boolean hasCycle(int course, List<List<Integer>> graph, int[] visited) {
        if(visited[course] == 1) return true;  // Found cycle
        if(visited[course] == 2) return false; // Already processed
        
        visited[course] = 1; // Mark as being visited
        
        for(int prereq : graph.get(course)) {
            if(hasCycle(prereq, graph, visited)) return true;
        }
        
        visited[course] = 2; // Mark as processed
        return false;
    }
}