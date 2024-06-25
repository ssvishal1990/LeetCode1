package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        //Set Boundries
        int row = 0, col = 0, rowTopToDownLimit = matrix.length, rowDownToTopLimit = 0,
                colLeftToRightLimit = matrix[0].length , colRightToLeftLimit = 0;
        do {
                // first set row as constant and add column numbers travel left to right
                for(col = 0; col < colLeftToRightLimit; col++){
                    result.add(matrix[row][col]);
                }

                col--;
                // now set col constant and update row traverse left to right
                for(row = 0 ; row < rowTopToDownLimit; row++){
                    result.add(matrix[row][col]);
                }
                row--;
                //now row constant again and travel right to left
                for(; col >= colRightToLeftLimit; col--){
                    result.add(matrix[row][col]);
                }
                col++;

                rowDownToTopLimit++;
                for(; row >= rowDownToTopLimit; row--){
                    result.add(matrix[row][col]);
                }
                row++;

                colLeftToRightLimit--;
                rowTopToDownLimit--;
                colRightToLeftLimit++;
        }while(result.size() < (matrix.length * matrix[0].length));
        return result;
    }
}
