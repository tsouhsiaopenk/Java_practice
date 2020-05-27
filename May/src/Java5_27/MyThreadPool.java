package Java5_27;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {
    // 仓库：可以使用自定义的阻塞队列
    private BlockingQueue<Runnable> queue;
    // 创建快递公司
    public MyThreadPool(int corePoolSize, int capacity) {
        // 创建仓库
        queue = new ArrayBlockingQueue<>(capacity);
        // 招聘员工
        for (int i = 0; i < corePoolSize; i++) {
            new MyThread(queue).start();
        }
    }

    // 快递公司放出来的送快递的接口（电话，营业点）：
    // 客户调用接口（打电话、去营业点办业务）。快递包裹放在仓库中
    public void execute(Runnable task) {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class MyThread extends Thread {
        private BlockingQueue<Runnable> queue;

        public MyThread(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                Runnable task = null;
                try {
                    task = queue.take();
                    task.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
