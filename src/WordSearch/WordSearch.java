package WordSearch;

import java.util.ArrayList;
import java.util.List;

record Index(int row, int col) {}
public class WordSearch {
    public boolean exist(char[][] board, String word) {


        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0 ; r < rows; r++){
            for(int c = 0 ; c < cols; c++){
                Index idx = new Index(r, c);
                Index idx2 = new Index(r, c);

                assert false;
                if(board[r][c] == word.charAt(0)){
                    List<List<Integer>> visited = new ArrayList<>();
                    if(dfs(board, r, c, word, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int currentCharIndex, List<List<Integer>> visited) {
        if(currentCharIndex == word.length())
        {
            System.out.println(visited);
            return true;
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(r);
        temp.add(c);

        if(r < 0 || r > board.length - 1
                || c < 0 || c > board[0].length - 1
                || board[r][c] != word.charAt(currentCharIndex)
                || visited.contains(temp)){
            return false;
        }

        visited.add(temp);
        currentCharIndex = currentCharIndex + 1;
        boolean result =  (dfs(board, r + 1, c, word, currentCharIndex, visited)
                || dfs(board, r - 1, c, word, currentCharIndex, visited)
                || dfs(board, r, c + 1, word, currentCharIndex, visited)
                || dfs(board, r, c - 1, word, currentCharIndex, visited));
        visited.remove(temp);
        return result;
    }

    private boolean dfs(char[][] board, int r, int c, String word, int currentCharIndex) {
        if(currentCharIndex == word.length())
        {
            return true;
        }



        if(r < 0 || r > board.length - 1
                || c < 0 || c > board[0].length - 1
                || board[r][c] != word.charAt(currentCharIndex)
                ){
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '*';
        boolean result =  (dfs(board, r + 1, c, word, currentCharIndex+ 1)
                || dfs(board, r - 1, c, word, currentCharIndex+ 1)
                || dfs(board, r, c + 1, word, currentCharIndex+ 1)
                || dfs(board, r, c - 1, word, currentCharIndex+ 1));
        board[r][c] = temp;
        return result;
    }

    public static  class  Test{
        public static void main(String[] args) {
            WordSearch ws = new WordSearch();
            char[][] board = new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
            String word = "ABCESEEEFS";
            System.out.println(ws.exist(board, word));
        }
    }
}
