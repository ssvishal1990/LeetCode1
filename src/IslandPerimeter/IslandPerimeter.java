package IslandPerimeter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        Set<List<Integer>> islandCoordinates = new HashSet<>();
        for(int row = 0 ; row < grid.length; row++){
            for(int col = 0 ; col < grid[0].length; col++){
                if(grid[row][col] == 1) {
                    dfs(grid, islandCoordinates, row, col);
                }
            }
        }

        int[][] directions = new int[][]{
                {1,0},
                {-1,0},
                {0,1},
                {0,-1},
        };

        int perimeter = getPerimeter(grid, islandCoordinates, directions);
        return perimeter;
    }

    private int getPerimeter(int[][] grid, Set<List<Integer>> islandCoordinates, int[][] directions) {

        int perimeter = 0;


        for(List<Integer> coordinate : islandCoordinates) {
            for (int[] dir : directions) {
                int x = coordinate.get(0) + dir[0];
                int y = coordinate.get(1) + dir[1];
                System.out.println("x :: " + x + "  y  ::" + y);
                if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length -1 || grid[x][y] == 0) { // going out of bounds || or stepping into water
                    perimeter += 1;
                } else if (grid[x][y] == 1) {
                    // nothing in this case;
                    perimeter += 0;
                }
            }
            System.out.println(perimeter);
        }
        return perimeter;
    }

    private void dfs(int[][] grid, Set<List<Integer>> islandCoordinates, int row, int col) {
        List<Integer> coordinates = new ArrayList<>();
        coordinates.add(row);
        coordinates.add(col);

        if(row < 0 || row > grid.length -1
                || col < 0 || col > grid[0].length -1
                || grid[row][col] == 0
                || islandCoordinates.contains(coordinates)){
            return;
        }
        islandCoordinates.add(coordinates);


        dfs(grid, islandCoordinates, row + 1, col);
        dfs(grid, islandCoordinates, row - 1, col);
        dfs(grid, islandCoordinates, row, col + 1);
        dfs(grid, islandCoordinates, row, col - 1);
    }

    public static  class  Test {
        public static  void  main(String[] args){
            IslandPerimeter islandPerimeter = new IslandPerimeter();
            int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
            int[][] grid2 = {{1}};
            int peri = islandPerimeter.islandPerimeter(grid2);
            System.out.println(peri);
        }
    }
}

