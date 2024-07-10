package ValidAnagram;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class ValidAnagram {

    Map<Character, Integer> getMapOfCharacterAndCount(String s){
        Map<Character, Integer> charCountOfS = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char t2 = s.charAt(i);
            charCountOfS.putIfAbsent(t2, 0);
            charCountOfS.put(t2, charCountOfS.get(t2) + 1);
        }
        return  charCountOfS;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> charCount = getMapOfCharacterAndCount(s);
        Map<Character, Integer> charCount2 = getMapOfCharacterAndCount(t);
        if(charCount.keySet().size() != charCount2.keySet().size()){
            return false;
        }

        for(Map.Entry<Character, Integer> es : charCount.entrySet()){
            if(!(charCount2.containsKey(es.getKey()) && charCount2.get(es.getKey()).equals(es.getValue()))){
                return false;
            }
        }

        for(Map.Entry<Character, Integer> es : charCount2.entrySet()){
            if(!(charCount.containsKey(es.getKey()) && charCount.get(es.getKey()).equals(es.getValue()))){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        validAnagram.isAnagram("abc", "aasdawe");
    }
}
