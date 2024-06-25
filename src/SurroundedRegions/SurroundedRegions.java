package SurroundedRegions;

import java.util.Arrays;
import java.util.Collections;

public class SurroundedRegions {
    public void solve(char[][] board){

        int rows = board.length;
        int cols = board[0].length;

        if(rows == 1 || cols == 1){
            return;
        }

        for(int row = 1 ; row < rows - 1; row++){
            for(int col = 1 ; col < cols  - 1 ; col++){
                if(board[row][col] == 'O'){
                    dfs(board, row, col);
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if(row < 1 || row > board.length -2
                || col < 1 || col > board[0].length -2
                || board[row][col] == 'X'){
            return;
        }
        board[row][col] = 'X';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    public static class Test{
        public static void main(String[] args) {
            char[][] grid= {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
            SurroundedRegions surroundedRegions = new SurroundedRegions();
            surroundedRegions.solve(grid);
            for(char[] g : grid){
                Collections.singletonList(g).forEach(System.out::println);
            }
        }
    }
}
