package Java5_24;


public class SeqPrint {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Print("A",null));
        Thread t2 = new Thread(new Print("B",t1));
        Thread t3 = new Thread(new Print("C",t2));
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
                if (t != null) {
                    t.join();
                }
                System.out.println(content);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
