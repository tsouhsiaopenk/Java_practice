package Java5_29;

import java.util.Date;
import java.util.concurrent.PriorityBlockingQueue;

public class MyScheduledThreadPool {
    // 员工
    private MyTimer[] threads;
    // 仓库
    private PriorityBlockingQueue<MyTimerTask> queue;

    public MyScheduledThreadPool(int capacity) {
        this.threads = new MyTimer[capacity];
        this.queue = new PriorityBlockingQueue<MyTimerTask>();
        for (int i = 0; i < capacity; i++) {
            threads[i] = new MyTimer(queue);
            threads[i].start();
        }
    }

    /*
        执行定时任务:
        一次传入任务，延迟时间（ms），间隔时间（ms）
     */
    public void schedule(Runnable runnable, long delay, long period) {
        MyTimerTask task = new MyTimerTask(runnable, (new Date().getTime() + delay), period);
        synchronized (queue) {
            queue.put(task);
            queue.notifyAll();
        }
    }

    // 测试代码：
    public static void main(String[] args) {
        MyScheduledThreadPool pool = new MyScheduledThreadPool(4);
        pool.schedule(() -> {
            System.out.println("ABC");
        }, 9999999, 1000);
        pool.schedule(() -> {
            System.out.println("D");
        }, 0, 1000);
    }
}

/*
    员工类：
        通过自定义的MyScheduleThreadPool向MyTimer（员工类）传入存放包裹的队列
        员工类不断进行取包裹，送包裹
 */
class MyTimer extends Thread {

    private PriorityBlockingQueue<MyTimerTask> queue;

    public MyTimer(PriorityBlockingQueue<MyTimerTask> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            // 注意：take 和 put,在达到下限和上限时，是阻塞等待
            try {
                MyTimerTask task = queue.take();
                synchronized (queue) {
                    long current = System.currentTimeMillis();
                    if (current < task.getNext()) {
                        // 一直等待到满足下次执行时间，需要从仓库重新取包裹
                        // 这个时候可能有时间更短（更紧急的包裹需要派送）
                        // 之前已经从仓库取出来了，要重新放回去
                        queue.wait(task.getNext() - current);
                        queue.put(task);
                    } else {
                        task.run();
                        if (task.getPeriod() > 0) {
                            task.setNext(task.getNext() + task.getPeriod());
                            queue.put(task);
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/*
    定时任务类:
        测试代码通过调用创建线程池的 schedule() 方法,传入了任务，以及下次执行时间，间隔时间
        将这些信息通过成员方法的信息保存在 MyTimerTask 对象中，由于定时任务具有优先级的关系（执行的先后顺序）
        所以, MyTimerTask 类需要重写 Comparable 接口。
        任务是通过实现 Runnable 接口的形式传入的，因此，需要还需要实现Runnable接口中的run()方法
 */
class MyTimerTask implements Runnable, Comparable<MyTimerTask> {
    private Runnable runnable;
    private long next;  // 下次执行时间
    private long period;    // 间隔时间

    public MyTimerTask(Runnable runnable, long next, long period) {
        this.runnable = runnable;
        this.next = next;
        this.period = period;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public long getPeriod() {
        return period;
    }

    @Override
    public int compareTo(MyTimerTask o) {
        return Long.compare(next, o.next);
    }

    @Override
    public void run() {
        runnable.run();
    }
}