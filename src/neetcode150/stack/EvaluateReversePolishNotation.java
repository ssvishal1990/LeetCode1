package neetcode150.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<String> numberStack = new Stack<>();
        for(String s : tokens){
            if(s.length() == 1 && !Character.isDigit(s.charAt(0))){
                char o = s.charAt(0);
                int result = 0;
                int b = Integer.parseInt(numberStack.pop());
                int a = Integer.parseInt(numberStack.pop());
                switch (o) {
                    case '+':
                        result += a + b;
                        break;
                    case '-':
                        result += a - b;
                        break;
                    case '*':
                        result += a * b;
                        break;
                    case  '/':
                        result += a/b;
                        break;
                }
                numberStack.push(Integer.toString(result));
            }else{
                numberStack.push(s);
            }
        }
        return Integer.parseInt(numberStack.pop());
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation ev = new EvaluateReversePolishNotation();
        String[] test = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(ev.evalRPN(test));
    }
}
