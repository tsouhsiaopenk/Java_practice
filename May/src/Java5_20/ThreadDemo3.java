package Java5_20;

public class ThreadDemo3 {
    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.interrupted());
            }
        }

        public static void main(String[] args) {
            MyRunnable target = new MyRunnable();
            Thread thread = new Thread(target,"李四");
            thread.start();
            thread.interrupt();
        }
    }
}
