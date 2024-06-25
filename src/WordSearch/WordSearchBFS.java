package WordSearch;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class WordSearchBFS {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int currentCharIndex = 0;
        for(int r = 0; r< rows; r++){
            for(int c = 0 ; c < cols ; c++){
                if(board[r][c] == word.charAt(currentCharIndex)){
                    boolean wordFound = bfs(board, r, c,  word, currentCharIndex);
                    if(wordFound){
                        return  true;
                    }else{
                        currentCharIndex = 0;
                    }
                }
            }
        }
        return false;
    }

    private boolean bfs(char[][] board, int r, int c, String word, int currentCharIndex) {
//        var index = new ArrayList<>();
//        var queue= new ArrayDeque<>();
        List<Integer> index = new ArrayList<>();
        Queue<List<Integer>> queue= new ArrayDeque<>();
        boolean wordFound = false;
        boolean[][] visited = new boolean[board.length][board[0].length]
;        index.add(r);
        index.add(c);
        queue.add(index);
        visited[r][c] = true;
        int[][] directions = new int[][]{
                {1,0},
                {-1,0},
                {0,1},
                {0,-1},
        };
        while (!queue.isEmpty()){
            var currentIndex = queue.poll();
            int x= currentIndex.get(0);
            int y = currentIndex.get(1);

            if (board[x][y] == word.charAt(currentCharIndex)) {
                currentCharIndex++;
                for (int[] dir : directions) {
                    int x2 = x + dir[0];
                    int y2 = y + dir[1];
                    List<Integer> temp = new ArrayList<>();
                    temp.add(x2);
                    temp.add(y2);

                    if (x2 < 0 || x2 > board.length - 1
                            || y2 < 0 || y2 > board[0].length - 1
                            || visited[x2][y2]) {
                        continue;
                    }

                    queue.add(temp);
                    visited[x2][y2] = true;
                }
                if (currentCharIndex == word.length()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static  class  Test{
        public static void main(String[] args) {
            WordSearchBFS ws = new WordSearchBFS();
            char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
            String word = "ABCCED";
            System.out.println(ws.exist(board, word));
        }
    }
}
