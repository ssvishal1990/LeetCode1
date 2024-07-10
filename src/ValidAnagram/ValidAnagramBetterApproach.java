package ValidAnagram;

import java.util.Arrays;

public class ValidAnagramBetterApproach {
    public boolean isAnagram(String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        String s2 = new String(s1);

        char[] s3 = t.toCharArray();
        Arrays.sort(s3);
        String s4 = new String(s3);

        return s2.equals(s4);

    }
}
