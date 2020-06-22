package Java6_22.Review;


public class TestDemo {
    private int count;

    public TestDemo(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        TestDemo test = new TestDemo(88);
        System.out.println(test.count);
    }
}
