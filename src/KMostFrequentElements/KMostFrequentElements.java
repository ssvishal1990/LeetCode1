package KMostFrequentElements;

import java.util.*;
import java.util.stream.Collectors;

public class KMostFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int num : nums){
            hashMap.putIfAbsent(num, 0);
            hashMap.put(num, hashMap.get(num) + 1);
        }

//        List<Map.Entry<Integer, Integer>> listToSortByValues = new ArrayList<>(hashMap.entrySet());
//        listToSortByValues.sort(Map.Entry.comparingByValue());
//        listToSortByValues.sort(Comparator.comparing(Map.Entry::getValue));
//        listToSortByValues.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        hashMap = hashMap.entrySet()
                .stream()
                .sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(hashMap);

        int[] result = new int[k];
        int i = 0;
        for(Map.Entry<Integer, Integer> es : hashMap.entrySet()){
            if(i == k) break;
            result[i++] = es.getKey();
        }
        return result;

    }

    public static void main(String[] args) {
        int k = 2;
        int[] input = new int[]{4,1,-1,2,-1,2,3};
        KMostFrequentElements kMostFrequentElements = new KMostFrequentElements();
        int[] result = kMostFrequentElements.topKFrequent(input, k);
        Arrays.stream(result).boxed().forEach(System.out::print);
    }
}
