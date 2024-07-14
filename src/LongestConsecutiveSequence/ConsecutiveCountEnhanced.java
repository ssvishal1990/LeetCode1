package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class ConsecutiveCountEnhanced {
    public int longestConsecutive(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for(int num : nums){
            integerSet.add(num);
        }
        int largestConsecutiveCount = 0, consecutiveCount = 0;
        for(int num : integerSet){
            if(!integerSet.contains(num - 1)){
                consecutiveCount = 1;
                while (integerSet.contains(num + consecutiveCount)){
                    consecutiveCount++;
                }

                largestConsecutiveCount = Math.max(consecutiveCount, largestConsecutiveCount);
            }
        }

        return Math.max(largestConsecutiveCount, consecutiveCount);
    }
}
