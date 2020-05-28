package Java5_28;

import sun.misc.Signal;

/**
 * 假设面包店里有面包师傅生产面包，消费者消费面包
 * 1.面包师傅有5个，可以一直生产面包，每次生产三个
 * 2，消费者有20个，可以一直消费面包，每次消费1个
 * 3.面包店库存的上限是100，下限是0
 */
public class SignalTest {
    // 库存
    private static int SUM;

    public static void main(String[] args) {

        // 5个面包师傅，同时启动
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    while (true) {
                        synchronized (Signal.class) {
                            while (SUM + 5 > 100) {
                                Signal.class.wait();
                            }
                            SUM += 5;
                            System.out.println(Thread.currentThread().getName() + "生产了面包，库存：" + SUM);
                            Thread.sleep(500);
                            Signal.class.notifyAll();
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "面包师傅【" + i + "】").start();
        }


        // 20 个消费者
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                try {
                    while (true){
                        synchronized(Signal.class){
                            while (SUM-3<0){
                                Signal.class.wait();
                            }
                            SUM -=3;
                            System.out.println(Thread.currentThread().getName() + "消费了面包,库存" + SUM);
                            Thread.sleep(500);
                            Signal.class.notifyAll();
                        }
                        Thread.sleep(200);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"消费者【" + i + "】").start();
        }
    }
}
