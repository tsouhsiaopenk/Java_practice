package Java3_29;

import java.util.Stack;

public class Solution2 {
    // 返回变换后的字符串(倒放着的)
    private String prune(String s) {
        Stack<Character> stack = new Stack();
        // 利用栈进行操作，如果监测到入栈的是#的话，出栈一个元素
//        for (char c:s.toCharArray()) {
//            if (c != '#'){
//                stack.push(c);
//            }else {
//                if (!stack.empty()){
//                    stack.pop();
//                }
//            }
//        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 如果是#，删除一个元素，结束本次循环
            if (stack.empty() && chars[i] == '#') {
                continue;
            } else if (!stack.empty() && chars[i] == '#') {
                stack.pop();
                continue;
            } else {
                // 不是的话，入栈
                stack.push(chars[i]);
            }
        }
        return String.valueOf(stack);
    }

    public boolean backspaceCompare(String S, String T) {
        String s = prune(S);
        String t = prune(T);
        if (s.equals(t)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        Solution2 solution2 = new Solution2();
        boolean b = solution2.backspaceCompare(s, t);
        System.out.println(b);
    }
}
