package DailyTemperature;

import java.util.Stack;

public class DailyTemperatureFurtherEnhanced {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> indexStack =  new Stack<>();
        for(int i = 0 ; i < temperatures.length; i++){
            if(!indexStack.isEmpty()){
                while (!indexStack.isEmpty() &&
                        temperatures[i] > temperatures[indexStack.peek()]){
                    int idx = indexStack.pop();
                    result[idx] = i - idx;
                }
            }
            indexStack.push(i);
        }
        return result;
    }
}
