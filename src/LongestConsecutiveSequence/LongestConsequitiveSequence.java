package LongestConsecutiveSequence;

import java.util.TreeSet;

public class LongestConsequitiveSequence {

    TreeSet<Integer> ts = new TreeSet<>();
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        for(int num : nums){
            ts.add(num);
        }
//        System.out.println(ts);
        boolean prevInit = false;
        int prev = 0;
        int consecutiveCount = 0;
        int largestConsecutiveCount = 0;
        for(int num : ts){
            if(!prevInit){
                prev = num;
                prevInit = true;
            }

            if(Math.abs(num - prev) == 1){
                consecutiveCount++;
                prev = num;
            }else{
                if(largestConsecutiveCount < consecutiveCount){
                    largestConsecutiveCount = consecutiveCount;
                }
                prev = num;
                consecutiveCount = 0;
            }
        }
        if(largestConsecutiveCount < consecutiveCount){
            largestConsecutiveCount = consecutiveCount;
        }
        return largestConsecutiveCount + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,-3,2,4,8,3,-1,6,-2,-4,7};
        LongestConsequitiveSequence lcs = new LongestConsequitiveSequence();
        System.out.println(lcs.longestConsecutive(arr));
    }
}
