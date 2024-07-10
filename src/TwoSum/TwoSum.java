package TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numAndIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            numAndIndex.putIfAbsent(nums[i], -1);
            numAndIndex.put(nums[i], i);
        }

        System.out.println(numAndIndex);
        int[] result = new int[2];
        for(int i = 0 ; i < nums.length; i++){
            int otherPartOfTarget = target - nums[i];
            if(numAndIndex.containsKey(otherPartOfTarget)){
                int otherPartOfTargetIndex = numAndIndex.get(otherPartOfTarget);
                if(otherPartOfTargetIndex == i){
                    continue;
                }

                if(i < otherPartOfTargetIndex){
                    result[0] = i;
                    result[1] = otherPartOfTargetIndex;
                }else{
                    result[0] = otherPartOfTargetIndex;
                    result[1] = i;
                }


            }
        }
        return result;
    }
}
