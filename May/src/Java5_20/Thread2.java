package Java5_20;

public class Thread2 {
    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName()
                        + ":别管我，我忙着转帐呢！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println(Thread.currentThread().getName()
                            + ":有内鬼，停止交易！");
                    break;
                }
            }
            System.out.println(Thread.currentThread().getName()
                    + ":啊！险些误了大事");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target, "李四");
        System.out.println(Thread.currentThread().getName()
                + ":李四开始转账。");
        thread.start();
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()
                + ":老板来电话了，得赶紧通知李四对方是个骗子！");
        thread.interrupt();
    }
}
