package Java5_27;

import java.util.concurrent.*;

public class ThreadVsThreadPool {

    public static void main(String[] args) {
        /**
         * 1.没有使用线程，送快递
         * 我自己送快递，再干自己的活
         */
        System.out.println("送快递到北京");
        System.out.println("送快递到上海");
        System.out.println("处理自己的业务");
        /**
         * 2.使用手动创建线程的方式，送快递
         * 雇佣两个人，让他们送快递
         * 同时，我也在干自己的事情
         */
        new Thread(()->{
            System.out.println("送快递到北京");
        }).start();
        new Thread(()->{
            System.out.println("送快递到上海");
        }).start();
        System.out.println("处理自己的业务");

        /**
         * 3.使用JDK的线程池来送快递
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                4,// 核心线程数，快递公司的正式员工——线程
                10,//最大线程数，总员工（正式工+临时工）——线程
                60,//空闲时间数
                TimeUnit.SECONDS,// 时间单位
                new ArrayBlockingQueue<>(1000),
                // 阻塞队列：快递公司的仓库，保存快递的包裹。——存放线程的容器
                new ThreadFactory(){

                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread();
                    }
                },
                new ThreadPoolExecutor.DiscardPolicy()
        );
        pool.execute(()->{
            System.out.println("送快递到北京");
        });
        pool.execute(()->{
            System.out.println("送快递到上海");
        });
        System.out.println("干自己的事");

        // 单线程池：只有一个正式工，没有临时工，仓库是没有边界的
        ExecutorService pool2 = Executors.newSingleThreadExecutor();
        // 固定大小的线程池：只有给定数量的正式工，没有临时工，仓库是无边界的
        ExecutorService pool3 = Executors.newFixedThreadPool(4);
        // 缓存的线程池：只有临时工，没有正式工，临时工数量不限，空闲时间60秒
        ExecutorService pool4 = Executors.newCachedThreadPool();
        // 计划任务线程池，给定数量的正式工，没有临时工，使用自己的创建线程的方式（定时任务线程）
        ExecutorService pool5 = Executors.newScheduledThreadPool(4);
    }
}
