package Java5_27;

/**
 * 阻塞式队列：
 * （1）基于数组的循环队列实现
 * （2）提供一个队列：
 * 取元素消费的时候，如果队列为空，阻塞等待
 * 如果队列满了，存元素生产的时候，阻塞等待
 *
 * @param <T>
 */
public class MyBlockingQueue<T> {
    private Object[] table;
    // 取元素时的的索引
    private int takeIndex;
    // 存放元素时的索引
    private int putIndex;
    // 保存元素大小
    private int size;

    public MyBlockingQueue(int capacity) {
        this.table = new Object[capacity];
    }

    public synchronized void put(T element) throws InterruptedException {
        while (size == table.length)
            wait();
        table[putIndex] = element;
        putIndex = (putIndex + 1) % table.length;
        size++;
        notifyAll();
        Thread.sleep(500);
    }

    public synchronized T take() throws InterruptedException {
        while (size == 0)
            wait();
        Object element = table[putIndex];
        takeIndex = (takeIndex + 1) % table.length;
        size--;
        notifyAll();
        Thread.sleep(500);
        return (T) element;
    }

    /**
     * 不能够使用volatile不加锁的方式完成size
     * 如果size可以和put/take并发、并行的执行，
     * 可能导致put/take中锋的size操作之前就返回了一个没有修改过的size,不正确
     * size++/size--之前返回size的值
     *
     * @return
     */
    public synchronized int size() {
        return size;
    }

    // 模拟使用自定义的阻塞式队列
    public static void main(String[] args) {
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(100);
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (queue) {
                            // 模拟生产面包
                            queue.put(1);
                            // 打印库存数量，是存在信息不一致的问题
                            // 使用不当：size是希望获取put方法调用并执行完元素操作时的
                            //          size两段代码是有原子性需求，但是没有保证原子性，出现问题
                            // 解决方案：加锁，可以是queue对象来加锁，也可以使用其他对象
                            System.out.println("存放面包+1:" + queue.size);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (queue) {
                            // 模拟消费面包
                            Integer e = queue.take();
                            System.out.println("消费面包-1:" + queue.size);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

}
