package FIndTheDuplibcateNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindDublicate {
    public int findDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i : nums){
            if(hs.contains(i)){
                return i;
            }else{
                hs.add(i);
            }
        }
        return -1;
    }
}
