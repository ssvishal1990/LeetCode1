package ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public record Index(int row, int col) {}

    public boolean isValidSudoku(char[][] board) {
        Index[] cellsFirstBox = new Index[]{
                new Index(0,0),
                new Index(0,3),
                new Index(0,6),
                new Index(3,0),
                new Index(3,3),
                new Index(3,6),
                new Index(6,0),
                new Index(6,3),
                new Index(6,6),
        };

        //First Objective is to check if the smaller 3 X 3 boxes are valid or not

        for (Index idx : cellsFirstBox){
            boolean isValid = validateSudokuFor3X3(board, idx);
            if(!isValid) return false;
        }

        //Now ValidateRowCol for complete board

        return validateCompleteBoard(board);
    }

    private boolean validateCompleteBoard(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean duplicateSpottedInRow = false, duplicateSpottedInCol = false;
        for(int r = 0 ; r < rows; r++){
            Set<Character> characterSet = new HashSet<>();
            for(int c = 0 ; c < cols; c++){
                if(board[r][c] == '.'){
                    continue;
                }
                 if(characterSet.contains(board[r][c])){
                     duplicateSpottedInCol = true;
                     break;
                 }
                 characterSet.add(board[r][c]);
            }
            if(duplicateSpottedInCol){
                break;
            }
        }

        for(int c = 0; c < cols; c++){
            Set<Character> characterSet = new HashSet<>();
            for(int r = 0 ; r < rows; r++){
                if(board[r][c] == '.'){
                    continue;
                }
                if(characterSet.contains(board[r][c])){
                    duplicateSpottedInRow = true;
                    break;
                }
                characterSet.add(board[r][c]);
            }

            if(duplicateSpottedInRow){
                break;
            }
        }

        return !duplicateSpottedInCol && !duplicateSpottedInRow;

    }

    private boolean validateSudokuFor3X3(char[][] board, Index idx) {
        int rowLimit = idx.row + 2;
        int colLimit = idx.col + 2;
        Set<Character> characterSet = new HashSet<>();
        for(int row = idx.row; row <= rowLimit; row++ ){
            for(int col = idx.col; col <= colLimit; col++){
                if(board[row][col] == '.'){
                    continue;
                }
                if(characterSet.contains(board[row][col])){
                    return false;
                }
                characterSet.add(board[row][col]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        ValidSudoku vs = new ValidSudoku();
        System.out.println(vs.isValidSudoku(board));
    }
}
