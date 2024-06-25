package SetZeroes;

import java.util.HashSet;
import java.util.Set;

public class SetZeroes {
    public int[][] setZeroes(int[][] matrix) {
        Set<Integer> columnIndexSet = new HashSet<>();
        Set<Integer> rowIndexSet = new HashSet<>();
        for(int row = 0 ; row < matrix.length ; row++){
            for(int col = 0 ; col < matrix[row].length; col++){
                if(matrix[row][col] == 0){
                    columnIndexSet.add(col);
                    rowIndexSet.add(row);
                }
            }
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;

        for(int row : rowIndexSet){
            for(int col = 0; col < colLength ; col++){
                matrix[row][col] = 0;
            }
        }

        for(int col : columnIndexSet){
            for(int row = 0; row < rowLength ; row++){
                matrix[row][col] = 0;
            }
        }

        return matrix;
    }
}
