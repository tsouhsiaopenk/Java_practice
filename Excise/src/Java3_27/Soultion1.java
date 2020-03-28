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
            // 判定是否为左括号，是的话就入栈
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
                continue;
            }
            // 若进来的不是左括号，先判断是否为空（因为要做pop操作）
            if (stack.empty()){
                return false;
            }
            // 取出栈顶元素
            Character top = stack.pop();
            // 若当前右括号与在栈顶的多括号相匹配的话，继续向下执行
            if (map.get(top) == c){
                continue;
            }
            // 其他情况均为非法
            return false;
        }
        // 最后，若栈为空的话，就说明括号匹配
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
