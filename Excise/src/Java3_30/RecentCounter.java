package Java3_30;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;
    public RecentCounter() {
         queue = new LinkedList<Integer>();
    }
    /*
        意思就是，让定义一个计数器，这个计数器只包含一个方法ping，
        每次ping传个毫秒单位的时间进去，他会确保每次传的时间都是
        递增的，用来模拟他调用ping的时间点，然后返回最近3000毫秒内调用ping的次数。
    */
    public int ping(int t) {
        // 用队列来实现，队列中元素个数就是调用ping的次数
        while (!queue.isEmpty()){
            // 若 a < b - 3000,就说明不在题目给定区间，需要从队列中删除
            if (queue.peek() >= t -3000){
                // 在给定区间的话，所有队列中的元素个数就是ping的调用次数
                break;
            }
            // 如果不在给定区间，删除队首元素，继续循环
            queue.poll();
        }
        // 将当前ping的时间点进行入队
        queue.add(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
