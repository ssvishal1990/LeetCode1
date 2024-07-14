package neetcode150.stack;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> bracketStack = new Stack<>();
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) != ')' && s.charAt(i) != '}' && s.charAt(i) != ']'){
                bracketStack.add(s.charAt(i));
            }else{
                if(bracketStack.isEmpty()){
                    return false;
                }
                char topChar = bracketStack.peek();
                char currentChar = s.charAt(i);
                if((currentChar == ')' && topChar == '(')
                        || (currentChar == '}' && topChar == '{')
                        || (currentChar == ']' && topChar == '[')){
                    bracketStack.pop();
                }else{
                    return false;
                }
            }
        }
        return bracketStack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "()";
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.isValid(test));
    }
}
