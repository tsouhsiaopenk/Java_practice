package Java5_20;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("这里是线程运行的代码");
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
