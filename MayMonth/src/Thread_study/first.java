package Thread_study;

public class first {


    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程");
            }
        }, "创建的线程").start();
        System.out.println("main");
    }
}
