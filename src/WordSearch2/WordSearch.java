package WordSearch2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    public List<String> findWords(char[][] board, String[] words) {


        int rows = board.length;
        int cols = board[0].length;
        Set<String> result = new HashSet<>();
        for(String word : words){
            for (int r = 0 ; r < rows; r++){
                for(int c = 0 ; c < cols; c++){
                    if(board[r][c] == word.charAt(0)){
//                        List<List<Integer>> visited = new ArrayList<>();
                        if(dfs(board, r, c, word, 0)){
                            result.add(word);
                        }
                    }
                }
            }
        }

        return result.stream().toList();
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
}
