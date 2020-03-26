package Java3_26;

/**
 * 使用数组来模拟队列
 * 队列的三种方法：
 * （1）入队列push()
 * （2）出队列poll()
 * （3）取队首元素peek()
 */
public class MyQueueByArray {
    private int[] array = new int[100];
    // [head,tail)之间的为有效元素
    private int head = 0;
    private int tail = 0;
    // 由于head等于tail时有两种情况，
    // 空或者满，因此可以使用size来判断
    private int size = 0;

    // 入队操作，我们让入队在队尾
    public void offer(int val) {
        // 先排除特殊情况，需要保证操作不能越界
        if (size == array.length) {
            // 满队列，无法插入
            return;
        }
        array[tail] = val;
        tail++;
        // 如果tail++之后超出了数组有效范围，就从头开始
        if (tail >= array.length) {
            tail = 0;
        }
        size++;
    }
    // 出队操作，我们让对手元素出队
    public Integer poll(){
        // 先排除特殊情况，不能是空队列
        if (size == 0){
            return null;
        }
        Integer ret = array[head];
        head++;
        if (head >= array.length){
            head = 0;
        }
        size--;
        return ret;
    }

    public Integer peek(){
        if (size == 0){
            return null;
        }
        return array[head];
    }

    public static void main(String[] args) {
        MyQueueByArray myQueueByArray = new MyQueueByArray();
        myQueueByArray.offer(1);
        myQueueByArray.offer(2);
        myQueueByArray.offer(3);
        myQueueByArray.offer(4);
        System.out.println(myQueueByArray.poll());
        System.out.println(myQueueByArray.peek());
        System.out.println(myQueueByArray.poll());
    }
}
