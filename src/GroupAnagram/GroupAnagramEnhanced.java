package GroupAnagram;

import java.util.*;

public class GroupAnagramEnhanced {

    public record StringAndIndex(String string, int index){}
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String s = new String(temp);
            anagramMap.putIfAbsent(s, new ArrayList<>());
            anagramMap.get(s).add(str);
        }

        anagramMap.forEach((key, value) -> result.add(anagramMap.get(key)));
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        GroupAnagramEnhanced groupAnagramEnhanced = new GroupAnagramEnhanced();
        String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
        groupAnagramEnhanced.groupAnagrams(input);
    }
}
