import java.util.*;

class AdjacencyList{
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

    public AdjacencyList(){}

    public void addVertex(int v){
        if(!graph.containsKey(v)){
            graph.put(v, new ArrayList<>());
        }
    }

    public void addEdge(int v, int e){
        addVertex(v);
        addVertex(e);

        graph.get(v).add(e);
        graph.get(e).add(v);
    }

    public void bfs(int src){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        visited.add(src);
        q.offer(src);

        while(!q.isEmpty()){
            int vertex = q.poll();
            //print vertex

            for(int neighbors: graph.get(vertex)){
                if(!visited.contains(neighbors)){
                    q.offer(neighbors);
                    visited.add(neighbors);
                }
            }

        }
    }

    public void dfs(int src){
        HashSet<Integer> visited = new HashSet<>();
        dfsHelper(src, visited);
    }

    private void dfsHelper(int src, HashSet<Integer> visited){
        visited.add(src);
        //print

        for(int neighbor: graph.get(src)){
            if(!visited.contains(neighbor)){
                dfsHelper(neighbor, visited);
            }
        }
    }
    
}