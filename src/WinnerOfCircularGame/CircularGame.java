package WinnerOfCircularGame;

import java.util.ArrayList;
import java.util.List;

public class CircularGame {
    public int findTheWinner(int n , int k) {
        List<Integer> ls = new ArrayList<>();

        //Initialize the circle table
        for(int i = 0; i < n ; i++ ) {
            ls.add(i , i+1);
        }

        //
        int currentNumIndex = 0;
        while(ls.size() != 1) {
            currentNumIndex += k -1;
            if(currentNumIndex >= ls.size()) {
                currentNumIndex = currentNumIndex % ls.size();
            }
            ls.remove(currentNumIndex);
        }
        return ls.getFirst();

    }
}
