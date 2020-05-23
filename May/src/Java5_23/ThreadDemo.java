package Java5_23;


public class ThreadDemo {
    public static class Counter {
        private long n = 0;

        public void increment() {
            n++;
        }

        public void decrement() {
            n--;
        }

        public long value() {
            return n;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final int count = 1000000;
        Counter counter = new Counter();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                counter.increment();
            }
        }, "李四");
        thread.start();
        for (int i = 0; i < count; i++) {
            counter.decrement();
        }
        System.out.println(counter.value());
        thread.join();
        System.out.println(counter.value());
    }
}
