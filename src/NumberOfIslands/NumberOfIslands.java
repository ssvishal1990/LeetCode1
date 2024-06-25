package NumberOfIslands;

import java.util.*;

public class NumberOfIslands {
    public int numIslands(char[][] grid){
        Set<List<Integer>> visited = new HashSet<>();
        int noOfIslands = 0;
        for(int row  = 0 ; row < grid.length; row++){
            for(int col = 0 ; col < grid[0].length; col++){
                List<Integer> temp = new ArrayList<>();
                temp.add(row);
                temp.add(col);
                if(grid[row][col] == '1' && !visited.contains(temp)){
                    bfs(grid, temp, visited);
                    noOfIslands++;
                }
            }
        }
        return  noOfIslands;
    }

    private void bfs(char[][] grid, List<Integer> index, Set<List<Integer>> visited) {
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(index);

        int[][] dir = {
                {1, 0},
                {-1, 0},
                {0, 1},
                {0, -1},
        };
        while (!queue.isEmpty()){
            List<Integer> currentIndex = queue.poll();
            for(int row = 0 ; row < dir.length ; row++){
                int x = currentIndex.get(0) + dir[row][0];
                int y = currentIndex.get(1) + dir[row][1];
                List<Integer> temp = new ArrayList<>();
                temp.add(x);
                temp.add(y);
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !visited.contains(temp)){
                    visited.add(temp);
                    queue.add(temp);
                }
            }
        }
    }

    public static class tMain {
        public static void main(String[] args){
            NumberOfIslands numberOfIslands = new NumberOfIslands();
            char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
            System.out.println(numberOfIslands.numIslands(grid));
        }
    }
}
