package PacificIslandWaterFlow;

import java.util.*;

public class PacificAtlanticWaterFloww {
    class Index {
        public int row;
        public int col;
        Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public boolean traverse(int[][] heights, int currentRow, int currentCol){
        Index idx = new Index(currentRow, currentCol);
        Queue<Index> queue = new ArrayDeque<>();
        queue.add(idx);
        Boolean reachedPacific = false;
        Boolean reachedAtlantic = false;

        // first lets see if we can reach pacific
        // west or north
        while (!queue.isEmpty()){
            Index currentIdx = queue.poll();

            if(currentIdx.row -1 == -1 || currentIdx.col -1 == -1 ){
                reachedPacific = true;
            }

            if(currentIdx.row + 1 == heights.length || currentIdx.col  + 1 == heights[0].length ){
                reachedAtlantic = true;
            }

            if(reachedPacific && reachedAtlantic){
                return true;
            }
            //N
            if(currentIdx.row - 1 >= 0 && heights[currentIdx.row][currentIdx.col]
                                        >= heights[currentIdx.row - 1][currentIdx.col]){
                queue.add(new Index(currentIdx.row - 1, currentIdx.col));
            }
            //W
            if(currentIdx.col  - 1 >= 0 && heights[currentIdx.row][currentIdx.col] >= heights[currentIdx.row][currentIdx.col - 1]){
                queue.add(new Index(currentIdx.row, currentIdx.col - 1));
            }

            //S
            if( currentIdx.row  + 1 < heights.length - 1 && heights[currentIdx.row][currentIdx.col] >= heights[currentIdx.row + 1][currentIdx.col]){
                queue.add(new Index(currentIdx.row + 1, currentIdx.col));
            }

            //E
            if(currentIdx.col + 1 < heights[0].length && heights[currentIdx.row][currentIdx.col] >= heights[currentIdx.row][currentIdx.col + 1]){
                queue.add(new Index(currentIdx.row, currentIdx.col + 1));
            }
        }
        return reachedAtlantic && reachedPacific;
    }
    public void pacificAtlantic() {
        int[][] arr = {{1,2,3},{8,9,4},{7,6,5}};
        System.out.println(traverse(arr, 2, 1));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        for(int row = 0 ; row < heights.length; row++){
            for(int col = 0 ; col < heights[0].length; col++){
                if(traverse(heights, row, col)){
                    List<Integer> validCoordinate = new ArrayList<>();
                    validCoordinate.add(row);
                    validCoordinate.add(col);
                    result.add(validCoordinate);
                }
            }
        }
        return result;
    }
}
