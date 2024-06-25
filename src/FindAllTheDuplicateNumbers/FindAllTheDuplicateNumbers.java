package FindAllTheDuplicateNumbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllTheDuplicateNumbers {
    public List<Integer> findDuplicates(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            if(freq.containsKey(i)){
                freq.put(i, freq.get(i) + 1);
            }else{
                freq.put(i, 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(Map.Entry<Integer, Integer> m : freq.entrySet()){
            if(m.getValue() == 2){
                result.add(m.getKey());
            }
        }
        return result;
    }

    public List<Integer> findDuplicates2(int[] nums){
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[nums.length + 1];
        for(int i : nums){
            freq[i]++;
            if(freq[i] == 2){
                result.add(i);
            }
        }
        return result;
    }
}
