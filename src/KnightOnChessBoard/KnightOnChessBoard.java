package KnightOnChessBoard;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightOnChessBoard {

    public record Position(int x, int y) {}
    int knight(int A, int B, int C, int D, int E, int F) {
        Position[] moveSet = new Position[]{
                new Position(1, 2),
                new Position(-1, -2),
                new Position(1, -2),
                new Position(-1, 2),
                new Position(2, 1),
                new Position(-2, -1),
                new Position(2, -1),
                new Position(-2, 1),
        };

        boolean[][] visited = new boolean[A+1][B+1];

        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(C- 1, D - 1));
        visited[C - 1][D - 1] = true;
        int moveCount = 0;

        while (!queue.isEmpty()){
            int nodesInCurrentLevel = queue.size();
            for(int i = 0; i < nodesInCurrentLevel; i++){
                Position currentPosition = queue.poll();
                if(currentPosition.x() == E - 1 && currentPosition.y() == F - 1){
                    return moveCount;
                }
                for(Position dir : moveSet){
                    int r = dir.x() + currentPosition.x();
                    int c = dir.y() + currentPosition.y();
                    if( r < 0 || r >  A -1
                            || c < 0 || c > B -1
                            || visited[r][c]){
                        continue;
                    }

                    queue.add(new Position(r, c));
                    visited[r][c] = true;
                }
            }
            moveCount++;
        }
        return -1;
    }
}
