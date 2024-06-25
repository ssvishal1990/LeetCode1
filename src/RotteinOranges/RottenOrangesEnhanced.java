package RotteinOranges;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOrangesEnhanced {
    public record Index (int row, int col) {}
    public int orangesRotting(int[][] grid) {
        Queue<Index> queue = new ArrayDeque<>();
        Index[] dir = new Index[]{
                new Index(1, 0),
                new Index(-1, 0),
                new Index(0, 1),
                new Index(0, -1)
        };
        int total = 0, rotten = 0, time = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int row = 0 ; row < rows ; row++){
            for(int col = 0 ; col < cols; col++){
                if(grid[row][col]== 1 || grid[row][col] == 2){
                    total++;
                }
                if(grid[row][col] == 2){
                    queue.add(new Index(row, col));
                }
            }
        }

        if(total == 0){
            return 0;
        }

        while (!queue.isEmpty()){
            int size = queue.size();
            rotten += size;
            if(rotten == total){
                return time;
            }
            
            time++;
            for(int i = 0 ; i < size ; i++){
                Index currentIdx = queue.poll();
                for(Index idx : dir){
                    int r = currentIdx.row() + idx.row();
                    int c = currentIdx.col() + idx.col();
                    if( r < 0 || r > rows -1
                            || c < 0 || c > cols -1
                            || grid[r][c] == 2
                            || grid[r][c] == 0
                    ){
                        continue;
                    }
                    grid[r][c] = 2;
                    queue.add(new Index(r, c));
                }
            }
        }
        return -1;
    }

}
