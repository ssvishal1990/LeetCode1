package LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    List<Integer> lexicalNumbers = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        helper(n, 1);
        return lexicalNumbers;
    }

    public void helper(int n , int current){
        if(current > n){
            return;
        }
        lexicalNumbers.add(current);
        helper(n, current * 10);
        if (current % 10 != 9){
           helper(n, current + 1);
        }
    }
}
