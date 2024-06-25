package RotteinOranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOraganges {

    int min = 0;
    public record Index (int row, int col) {}

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int r = 0 ; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if(grid[r][c] == 2){
                    bfs(grid, r, c);
                }
            }
        }
        for(int r = 0 ; r < rows; r++){
            for (int c = 0; c < cols; c++){
                System.out.print(grid[r][c]);
                if(grid[r][c] == 1){
                    return -1;
                }
            }
            System.out.println("\n");
        }


        return min;
    }

    private void bfs(int[][] grid, int r, int c) {
        Queue<Index> queue = new ArrayDeque<>();
        queue.add(new Index(r, c));
        Index[] dir = new Index[]{
                new Index(1, 0),
                new Index(-1, 0),
                new Index(0, 1),
                new Index(0, -1)
        };

        while (!queue.isEmpty()){

            int orangesToRotInCurrentIteration = queue.size();
            int prevMin = min;
            for(int i = 0 ; i < orangesToRotInCurrentIteration; i++){
                Index currentIdx = queue.poll();
                for (Index d : dir){
                    int row = currentIdx.row + d.row();
                    int col = currentIdx.col + d.col();
                    if(row < 0  || row > grid.length - 1
                            || col < 0 || col > grid[0].length -1
                            || grid[row][col] == 0
                            || grid[row][col] == 2){
                        continue;
                    }
                    grid[row][col] = 2;
                    queue.add(new Index(row, col));
                    if(prevMin == min){
                        min++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        RottenOraganges ro = new RottenOraganges();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(ro.orangesRotting(grid));
    }
}
