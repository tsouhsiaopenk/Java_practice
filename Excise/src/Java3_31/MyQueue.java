package Java3_31;

import java.util.Stack;

public class MyQueue {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        // 1.先把B中的元素都挪到A中
        while (!B.empty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        // 2.新元素入A
        A.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        // 1.先判断特殊情况
        if (empty()) {
            return -1;
        }
        // 2.将A中 的元素全部挪到B中
        while (!A.empty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        // 3.返回栈顶元素
        return B.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        // 1.如果为空，返回-1
        if (empty()) {
            return -1;
        }
        // 2.将A的元素都挪到B
        while (!A.empty()) {
            int tmp = A.pop();
            B.push(tmp);
        }
        return B.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return A.empty() && B.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
