package Java6_6.OJ;
import java.util.Stack;
/*
    用两个栈来实现一个队列，完成队列的Push和Pop操作。队列中的元素为int类型
 */

public class Solution {
    // 数据栈
    Stack<Integer> stack1 = new Stack<Integer>();
    // 辅助栈
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        // 队列中没有元素，也就是数据栈中没有元素，返回 -1
        if (stack1.isEmpty()){
            return -1;
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        int result = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return result;
    }
}