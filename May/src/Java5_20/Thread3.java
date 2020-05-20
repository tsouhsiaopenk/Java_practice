package Java5_20;

public class Thread3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable target = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(Thread.currentThread().getName()
                    +":我还在工作！");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":我结束了！");
        };
        Thread thread1 = new Thread(target,"李四");
        Thread thread2 = new Thread(target,"王五");
        System.out.println("先让李四开始工作");
        thread1.start();
        thread1.join();
        System.out.println("李四工作结束了，让王五开始工作");
        thread2.start();
        thread2.join();
        System.out.println("王五工作结束了");
    }
}
