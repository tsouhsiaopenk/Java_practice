package Java5_24;

public class SequencePrint {
    public static void main(String[] args) {
        Thread A = new Thread(() -> {
            synchronized (SequencePrint.class) {
                System.out.println("A");
                SequencePrint.class.notifyAll();
            }
        });
        Thread B = new Thread(() -> {
            synchronized (SequencePrint.class) {
                try {
                    SequencePrint.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("B");
                SequencePrint.class.notify();
            }
        });
        Thread C = new Thread(() -> {
            synchronized (SequencePrint.class) {
                try {
                    SequencePrint.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("C");
            }
        });
        C.start();
        B.start();
        A.start();
    }
}
