package patterns.graphs.solutions;
import java.util.*;

class Solution {
    private final int[][] DIRS = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) return new ArrayList<>();
        
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        
        // Process first and last row
        for (int col = 0; col < cols; col++) {
            dfs(heights, 0, col, pacific, Integer.MIN_VALUE);
            dfs(heights, rows-1, col, atlantic, Integer.MIN_VALUE);
        }
        
        // Process first and last column
        for (int row = 0; row < rows; row++) {
            dfs(heights, row, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, row, cols-1, atlantic, Integer.MIN_VALUE);
        }
        
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
    
    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length 
            || visited[row][col] || heights[row][col] < prevHeight) 
            return;
        
        visited[row][col] = true;
        
        for (int[] dir : DIRS) {
            dfs(heights, row + dir[0], col + dir[1], visited, heights[row][col]);
        }
    }
 }