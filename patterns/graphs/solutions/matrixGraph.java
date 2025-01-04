package patterns.graphs.solutions;
import java.util.*;

public class matrixGraph {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    //use w/ flood fill type problems
    //find connecting components/regions
    //need to explore full regions before moving on
    //go deep into a path prior to backtracking
    //recursive
    public void dfs(int[][] grid, int row, int col, boolean[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;

        if(!isValid(row, col, rows, cols) || visited[row][col] == true){
            return;
        }

        visited[row][col] = true;

        System.out.println(grid[row][col]);
        for(int[] dir : DIRECTIONS){
            dfs(grid, row + dir[0], col + dir[1], visited);
        }
    }

    //use when finding shortest path in maze
    //spreading/propagation problems (rotting oranges)
    //when distance matters
    //checks all options at current level before going deeper
    public void bfs(int[][] grid, int startRow, int startCol){
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];

        q.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];

            System.out.println(grid[row][col]);

            //Go in all 4 directions and add a new valid move if it exists
            for(int[] dir: DIRECTIONS){
                int newRow = row+dir[0];
                int newCol = col + dir[1];

                //Checks if the newRow is in bounds and it hasn't been visited already
                if(isValid(newRow, newCol, rows, cols) && visited[newRow][newCol] != true){
                    q.offer(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true;
                }
            }
        }
        
    }

    private boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}
