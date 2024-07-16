package DailyTemperature;

import java.util.Stack;

//Accepted But it can still be enhanced
public class DailyTemoperatureEnhanced {

    public record Temp(int temperature, int index){}
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Temp> temperatureStack = new Stack<>();
        int[] result = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length; i++){
            if(temperatureStack.isEmpty()){
                Temp t = new Temp(temperatures[i], i);
                temperatureStack.push(t);
            }else{
                if(temperatures[i] > temperatureStack.peek().temperature){
                    while (!temperatureStack.isEmpty()
                            && temperatures[i] > temperatureStack.peek().temperature){
                        Temp t = temperatureStack.pop();
                        result[t.index] = i - t.index;
                    }
                    temperatureStack.push(new Temp(temperatures[i], i));
                }else{
                    temperatureStack.push(new Temp(temperatures[i], i));
                }
            }
        }
        return result;
    }
}
