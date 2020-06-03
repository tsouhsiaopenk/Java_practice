package Java6_3.day3;

import org.junit.Test;

import java.util.Stack;

public class Parenthesis {
    @Test
    public void test(){
        String s = "(()a())";
        System.out.println(chkParenthesis(s,6));
    }

    public static void main(String[] args) {
        String s = "(()())";
        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.chkParenthesis(s,6));
    }
    // 判断是否为合法的括号串
    public boolean chkParenthesis(String A, int n) {
        // 合法性校验
        if (A.length() != n){
            return false;
        }
        Stack<Character> stack= new Stack<>();
        for (Character c: A.toCharArray()) {
            if (c == '(' || c == ')'){
                if (c == '('){
                    stack.push('(');
                }
                else {
                    if (stack.isEmpty()){
                      return false;
                    } else if (stack.peek() == '('){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }else {
                return false;
            }

        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
//    {
//        Stack<Character> stack= new Stack<>();
//        for (int i = 0; i < A.length(); i++) {
//            Character c = A.charAt(i);
//            if (c == '('){
//                stack.push(c);
//                continue;
//            }
//            if (stack.isEmpty()){
//                return false;
//            }
//            Character top = stack.pop();
//            if (top == '('){
//                continue;
//            }
//            return false;
//        }
//        if (stack.isEmpty()){
//            return true;
//        }
//        return false;
//    }
}
