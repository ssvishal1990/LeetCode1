package SurroundedRegions;

import java.util.Collections;

public class SurroundedRegionEnhanced {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Doing it for first and last col
        for(int i = 0 ; i < rows; i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
            if(board[i][cols-1] == 'O'){
                dfs(board, i, cols - 1);
            }
        }

        // Doing it for first and last row
        for(int c = 0 ; c < cols ; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }
            if(board[rows - 1][c] == 'O'){
                dfs(board, rows -1, c);
            }
        }
//        System.out.println("---------------After DFS------------");
//        for(char[] g : board){
//            Collections.singletonList(g).forEach(System.out::println);
//        }

        for(int r = 0 ; r < rows; r++){
            for(int c = 0; c < cols ; c++){
                if(board[r][c] == 'T'){
                    board[r][c] = 'O';
                }else if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int col) {
        if(row < 0 || row > board.length - 1
                || col < 0 || col > board[0].length -1
                || board[row][col] == 'X'
                || board[row][col] == 'T'){
            return;
        }

        board[row][col]= 'T';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col - 1);
    }

    public static void main(String[] args) {
        char[][] grid= {{'X','O','X'},{'O','X','O'},{'X','O','X'}};
        SurroundedRegionEnhanced surroundedRegions = new SurroundedRegionEnhanced();
        surroundedRegions.solve(grid);
        System.out.println("---------------Final Answer------------");
        for(char[] g : grid){
            Collections.singletonList(g).forEach(System.out::println);
        }
    }
}
