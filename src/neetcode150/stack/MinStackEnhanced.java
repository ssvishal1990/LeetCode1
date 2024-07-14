package neetcode150.stack;

import java.util.Stack;

public class MinStackEnhanced {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStackEnhanced() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || (minStack.peek() >= val)){
            minStack.push(val);
        }
    }

    public void pop() {
        int ele = stack.pop();
        if(ele == minStack.peek()){
            minStack.pop();
        }
    }


    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
