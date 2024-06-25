package PacificIslandWaterFlow;

import java.util.*;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        for(int c = 0 ; c < cols ; c++) {
            dfs(0, c, rows, cols, pacific,  heights[0][c], heights);
            dfs(rows -1, c, rows, cols, atlantic, heights[rows -1][c], heights);
        }

        for(int r = 0; r < rows ; r++){
            dfs(r, 0, rows, cols, pacific, heights[r][0], heights);
            dfs(r, cols -1, rows, cols, atlantic, heights[r][cols - 1], heights);
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int r = 0; r < rows; r++ ){
            for(int c = 0; c < cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    public void dfs(int row, int col, int rows, int cols,  boolean[][] visited, int prevHeight, int[][] heights) {
        if(row < 0 || row >= rows ||
            col < 0 || col >= cols || visited[row][col] ||
                prevHeight > heights[row][col]
            ){
            return ;
        }
//
//        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || prevHeight > heights[row][col])
//            return;

        visited[row][col] = true;
        dfs(row + 1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row - 1, col, rows, cols, visited, heights[row][col], heights);
        dfs(row, col + 1, rows, cols, visited, heights[row][col], heights);
        dfs(row, col - 1, rows, cols, visited, heights[row][col], heights);
    }
}
