package Java3_27;

import java.util.*;

class Solution1 {
    public boolean isValid(String s) {
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        // 先创建一个栈，栈中保存字符
        Stack<Character> stack = new Stack<>();
        // 循环遍历每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 判定是否为左括号，是的化就入栈
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            if (stack.empty()){
                return false;
            }
            Character top = stack.pop();
            if (map.get(top) == c){
                continue;
            }
            return false;
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
