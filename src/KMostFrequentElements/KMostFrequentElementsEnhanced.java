package KMostFrequentElements;

import java.util.*;

public class KMostFrequentElementsEnhanced {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> listOfEntries = new ArrayList<>(hashMap.entrySet());
        listOfEntries.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int[] result = new int[k];
        for(int i = 0 ; i < k; i++){
            result[i] = listOfEntries.get(i).getKey();
        }
        return result;
    }
}
