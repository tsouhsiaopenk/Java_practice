package Java3_31;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {

    private Queue<Integer> A = new LinkedList<>();
    private Queue<Integer> B = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        // x 进A队列
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (empty()){
            return -1;
        }
        // 把A中的元素挪移到B队列中
        while(A.size() > 1){
            Integer font = A.poll();
            B.offer(font);
        }
        // 把A队列中剩下的一个元素返回
        int ret = A.poll();
        swapAB();
        return ret;
    }
    private void swapAB(){
        Queue<Integer> tmp = A;
        A = B;
        B = tmp;
    }
    /** Get the top element. */
    public int top() {
        if (empty()){
            return -1;
        }
        // 把A中的元素挪移到B队列中
        while(A.size() > 1){
            Integer font = A.poll();
            B.offer(font);
        }
        // 把A队列中剩下的一个元素返回
        int ret = A.poll();
        B.offer(ret);
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
