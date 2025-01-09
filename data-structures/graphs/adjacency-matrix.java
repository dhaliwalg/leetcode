
import java.util.LinkedList;
import java.util.Queue;

class AdjacencyMatrix{
    private final int[][] DIRECTIONS = {{1,0},{0,1},{-1,0},{0,-1}};

    public void bfs(int[][] graph, int srcRow, int srcCol){
        int rows = graph.length;
        int cols = graph[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        
        q.offer(new int[]{srcRow, srcCol});
        visited[srcRow][srcCol] = true;

        while(!q.isEmpty()){
            int[] e = q.poll();
            int r = e[0];
            int c = e[1];

            for(int[] dir: DIRECTIONS){
                int newR = r + dir[0];
                int newC = c + dir[1];

                if(isValid(newR, newC, rows, cols) && visited[newR][newC] != true){
                    visited[newR][newC] = true;
                    q.offer(new int[]{newR, newC});
                }
            }
        }
        
    }

    private boolean isValid(int srcRow, int srcCol, int rows, int cols) {
        return srcRow >= 0 && srcRow < rows && srcCol >= 0 && srcCol < cols;
    }

    public void dfs(int[][] graph, int srcRow, int srcCol){
        int rows = graph.length;
        int cols = graph[0].length;

        boolean[][] visited = new boolean[rows][cols];
        dfsHelper(graph, srcRow, srcCol, visited);
    }

    private void dfsHelper(int[][] graph, int srcRow, int srcCol, boolean[][] visited){
        int rows = graph.length;
        int cols = graph[0].length;
        visited[srcRow][srcCol] = true;

        for(int[] dir: DIRECTIONS){
            int newR = srcRow + dir[0];
            int newC = srcCol + dir[1];

            if(isValid(newR, newC, rows, cols) && visited[newR][newC] != true){
                dfsHelper(graph, newR, newC, visited);
            }
        }
    }

}