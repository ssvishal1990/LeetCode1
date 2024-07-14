package neetcode150.stack;

import java.util.ArrayList;
import java.util.List;

class MinStack {
    List<Integer> integerList;
    int idx;
    int min;

    public MinStack() {
        integerList = new ArrayList<>();
        idx = 0;
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val < min){
            min = val;
        }
        integerList.add(idx++, val);
    }

    public void pop() {
        int currentEle = top();
        integerList.remove(--idx);
        if(currentEle == min){
            min = findMin();
        }
    }

    public int top() {
       return integerList.get(idx - 1);
    }

    public int getMin() {
        return min;
    }

    public int findMin(){
        int minimum = Integer.MAX_VALUE;
        for(int num : integerList){
            if(num < minimum){
                minimum = num;
            }
        }
        return minimum;
    }
}
