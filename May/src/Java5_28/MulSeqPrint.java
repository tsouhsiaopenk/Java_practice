package Java5_28;

/**
 * 创建三个线程
 * （1）同时执行
 * （2）打印结果为ABC，需要循环打印10次
 * 每次打印之后、等得其余线程打印完，再往下执行
 */
public class MulSeqPrint {
    public static void print(){
        for (int i = 0; i < Print.ARRAY.length ; i++) {
            new Thread(new Print(i)).start();
        }
    }

    private static class Print implements Runnable{
        private int idx;
        public static String[] ARRAY = {"A","B","C","D","E"};
        private static int INDEX;

        public Print(int idx){
            this.idx = idx;
        }
        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    synchronized (ARRAY){
                        while (idx != INDEX){
                            ARRAY.wait();
                        }
                        System.out.print(ARRAY[idx]);
                        if (INDEX == ARRAY.length-1){
                            System.out.println();
                        }
                        INDEX = (INDEX + 1) % ARRAY.length;
                        ARRAY.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        print();
    }
}
