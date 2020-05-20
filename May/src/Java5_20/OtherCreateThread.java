package Java5_20;

public class OtherCreateThread {
    public static void main(String[] args) {
        // 使用匿名类创建 Thread 子类对象
        Thread t1 = new Thread(){
            public void run(){
                System.out.println("t1使用匿名类创建 Thread 子类对象");
            }
        };
        // 使用 Runnable 子类对象
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t2使用匿名内部类创建 Runnable 子类对象");
            }
        });

        // 使用lambda 表达式创建 Runable 子类对象
        Thread t3 = new Thread(()-> System.out.println("t3使用匿名类创建 Thread 子类对象"));
        Thread t4 = new Thread(()->{
            System.out.println("t4使用匿名类创建Thread子类对象");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
