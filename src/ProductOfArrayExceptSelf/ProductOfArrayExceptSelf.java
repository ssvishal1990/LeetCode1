package ProductOfArrayExceptSelf;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayExceptSelf {
    int[] productOfArrayExceptSelf(int[] nums){
        int productOfAllNumbers = 1;
        List<Integer> zeroIndexes = new ArrayList<>();
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 0) {
                zeroIndexes.add(i);
            }else{
                productOfAllNumbers *= nums[i];
            }
        }
        int[] result = new int[nums.length];
        if(zeroIndexes.size() > 1) {
            return result;
        }else if(zeroIndexes.size() == 1){
            int skipIndex = zeroIndexes.getFirst();
            result[skipIndex] = productOfAllNumbers;
            return result;
        }
        for(int i = 0 ; i < nums.length; i++){
            result[i] = productOfAllNumbers/nums[i];
        }
        return result;
    }
}
