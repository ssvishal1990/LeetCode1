package DecodeString;

import javax.swing.*;
import java.util.Stack;

public class DecodeString5 {
    public String decodeString(String s) {
        Stack<Character> characterStack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != ']'){
                characterStack.push(c);
            }else{
                StringBuilder sb1 = new StringBuilder();
                while(characterStack.peek() != '['){
                    sb1.append(characterStack.pop());
                }

                characterStack.pop();

                StringBuilder num = new StringBuilder();
                while(!characterStack.isEmpty() && Character.isDigit(characterStack.peek())){
                    num.append(characterStack.pop());
                }
                num.reverse();
                sb1.reverse();
//                System.out.println("NUM :: " + num + "  stringToRepeat  :: " + sb1);
                int k = Integer.parseInt(num.toString().isBlank() ? "0" : num.toString());
                k = k == 0 ? 0 : k -1;
                sb1.repeat(sb1.toString(), k);
//                System.out.println("After repeat :: " + sb1 + "  k ::" + (k + 1));
                for(int j = 0 ; j < sb1.length(); j++){
                    characterStack.push(sb1.charAt(j));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!characterStack.isEmpty()){
            sb.append(characterStack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
//        String test = "2[a]2[l]";
//        String test = "2[a]2[lee2[ff]]2[c]";
//        String test = "2[lee2[ff]]";
        String test = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
        DecodeString5 ds = new DecodeString5();
        System.out.println(ds.decodeString(test));
    }
}
