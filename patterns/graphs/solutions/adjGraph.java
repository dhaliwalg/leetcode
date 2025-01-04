package patterns.graphs.solutions;
import java.util.*;

public class adjGraph {
    HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

    public adjGraph(){}

    void addVertex(int vertex){
        if(!adjacencyList.containsKey(vertex)){
            adjacencyList.put(vertex, new ArrayList<>());
        }
    }

    public void addEdge(int src, int dst){
        addVertex(src);
        addVertex(dst);

        adjacencyList.get(src).add(dst);
        adjacencyList.get(dst).add(src);
    }

    //Finding shortest path
    //Level by level traversal
    //Finding nodes at k distance
    //Need closest/shortest solution first
    public void bfs(int src){
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        visited.add(src);
        q.offer(src);

        while(!q.isEmpty()){
            int v = q.poll();
            System.out.println(v);

            for(int neighbor: adjacencyList.get(v)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    q.offer(neighbor);
                }
            }
        }
    }

    //Use when need to find paths between nodes
    //Cycle detection
    //Top Sort (Course Schedule)
    //Tree-like traversals
    public void dfs(int src){
        Set<Integer> visited = new HashSet<>();
        dfsHelper(src, visited);
    }

    void dfsHelper(int src, Set<Integer> visited){
        visited.add(src);
        System.out.println(src);

        for(int neighbor: adjacencyList.get(src)){
            if(!visited.contains(neighbor)){
                dfsHelper(neighbor, visited);
            }
        }
    }
}
