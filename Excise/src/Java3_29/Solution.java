package Java3_29;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        // 遍历逆波兰表达式（后缀）字符串
        for (String s : tokens) {
            switch (s){
                case "+":{
                    stack.push(stack.pop()+stack.pop());
                }
                case "-":{
                    // 先出来的是表达式中的后面一个值
                    stack.push(-stack.pop() + stack.pop());
                }
                case "*":{
                    stack.push(stack.pop()*stack.pop());
                }
                case "/":{
                    int num = stack.pop();
                    stack.push(num / stack.pop());
                }
                default:{
                    stack.push(Integer.parseInt(s));
                }
            }
        }
        return stack.pop();
    }
}
