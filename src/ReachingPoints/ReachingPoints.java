package ReachingPoints;

import java.util.HashMap;
import java.util.Map;

public class ReachingPoints {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(sx > tx || sy > ty){
            return false;
        }

        if(sx == tx && sy == ty){
            return true;
        }


        boolean result = reachingPoints(sx, sy + sx, tx, ty) ||
                reachingPoints(sx + sy, sy, tx, ty);

        return result;
    }
}
