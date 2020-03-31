package Java3_31;

import java.util.Stack;

class MinStack {
    // A 栈用来存放元素
    // B 栈用来保存此时的最小元素
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        // A直接入栈
        A.push(x);
        // B需要判断
        if (B.empty()) {
            B.push(x);
        } else {
            if (B.peek() > x) {
                B.push(x);
            } else {
                B.push(B.peek());
            }
        }
    }

    public void pop() {
        A.pop();
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
}
