package Java4_1;

import java.util.Stack;

public class Solution {
    // 栈的压入，弹出序列
    /*
        总的思路是：如果popA是出栈顺序，我们可以按照出栈的顺序把栈里的元素出完。
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        // 如果入栈的集合是空的，直接返回false
        if (pushA.length == 0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0,j = 0;i < pushA.length;i++){
            // 每次循环将入栈序列依次添加进栈中
            stack.push(pushA[i]);
            // 如果栈顶元素和出栈序列一致，就出栈，如果入栈的元素全部出栈，就说出栈顺序是正确的
            while(j < popA.length && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
