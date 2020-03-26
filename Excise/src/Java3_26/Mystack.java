package Java3_26;

import java.util.Stack;

/**
 * 此类用于模拟栈
 * 三种方法：
 * 1，入栈 push()
 * 2，出栈 pop()
 * 3，取栈顶元素 peek()
 */
public class Mystack {
    // 这里以 int 型元素为例，不考虑扩容
    private int[] array = new int[100];
    private int size = 0;// 有效元素个数

    // 入栈
    public void push(int val) {
        array[size++] = val;
    }

    // 出栈
    public int pop() {
        int result = array[size - 1];
        size--;
        return result;
    }

    // 取栈顶元素
    public int peek() {
        return array[size - 1];
    }

    public static void main(String[] args) {
        Mystack mystack = new Mystack();
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        System.out.println(mystack.pop());
        System.out.println(mystack.pop());
        System.out.println(mystack.peek());
    }
}
