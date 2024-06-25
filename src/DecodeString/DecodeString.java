package DecodeString;

import java.util.Stack;

public class DecodeString {

    public StringBuilder formDecodedStringPart(StringBuilder str, int count){
        return new StringBuilder(String.valueOf(str).repeat(count));
    }


    public String solution(String s) {
        Stack<Character> parenthesisStack = new Stack<>();
        Stack<StringBuilder> subStringDecodedStack = new Stack<>();
        Stack<Integer> repeaterCountStack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++)
        {
            if(Character.isDigit(s.charAt(i))){
                repeaterCountStack.push(Integer.parseInt(String.valueOf(s.charAt(i))));
            }else if(s.charAt(i) == '['){
                parenthesisStack.push(s.charAt(i));
                if(!subStringDecodedStack.isEmpty()){
                    result.append(subStringDecodedStack.pop());
                }
            }else if(s.charAt(i) == ']') {
                // pop from parenthesis Stack and numberic Stack
                // form the decoded string and set it to last value
                // decoded String = decode(subStringDecodedStack, count)
                // subStringDecodedStack.first() = pop().append(decoded String)
                parenthesisStack.pop();
                StringBuilder decodedString = formDecodedStringPart(subStringDecodedStack.pop(), repeaterCountStack.pop());
                if(subStringDecodedStack.isEmpty()){
                    result.append(decodedString.toString());
                }else{
                    subStringDecodedStack.push(subStringDecodedStack.pop().append(decodedString));
                }
            }else{
                if(subStringDecodedStack.isEmpty())
                {
                    subStringDecodedStack.push(new StringBuilder(Character.toString(s.charAt(i))));
                }else if(parenthesisStack.size() > subStringDecodedStack.size()){
                    subStringDecodedStack.push(new StringBuilder(Character.toString(s.charAt(i))));
                }else{
                    subStringDecodedStack.push(subStringDecodedStack.pop().append(s.charAt(i)));
                }
            }

        }
        if(!subStringDecodedStack.isEmpty()){
            result.append(subStringDecodedStack.pop());
        }
        return result.toString();
    }
}
