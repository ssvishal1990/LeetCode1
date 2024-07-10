package GroupAnagram;

import java.util.*;

public class GroupAnagram {

        public List<List<String>> groupAnagrams(String[] strs) {
            Set<List<String>> result = new LinkedHashSet<>();
            for(int i = 0 ; i < strs.length; i++){
                char[] charSeq = strs[i].toCharArray();
                Arrays.sort(charSeq);
                String s1 = new String(charSeq);

                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);
                for(int j = 0 ; j < strs.length; j++){
                    if(i == j){
                        continue;
                    }

                    char[] charSeq2 = strs[j].toCharArray();
                    Arrays.sort(charSeq2);
                    String s2 = new String(charSeq2);

                    if(s1.equals(s2)){
                        anagrams.add(strs[j]);
                    }
                    Collections.sort(anagrams);
                }
                result.add(anagrams);
            }
            return result.stream().toList();
        }
}
