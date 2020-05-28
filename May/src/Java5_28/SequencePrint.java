package Java5_28;

public class SequencePrint {
    /**
     * 三个线程：
     * 第一个只能打印A，第二个只能打印B，第三个这能打印C
     * 要求：
     * （1）三个线程同时执行
     * （2）打印结果：ABC
     * 思路：join
     */
    public static void print() {
        Thread t1 = new Thread(new Print("A", null));
        Thread t2 = new Thread(new Print("B", t1));
        Thread t3 = new Thread(new Print("C", t2));
        t1.start();
        t2.start();
        t3.start();
    }

    private static class Print implements Runnable {
        private String content;
        private Thread t;

        public Print(String content, Thread t) {
            this.content = content;
            this.t = t;
        }

        @Override
        public void run() {
            try {
                if (t != null)
                    t.join();
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        print();
    }
}
