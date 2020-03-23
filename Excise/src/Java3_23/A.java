package Java3_23;

/**
 * 请编写代码使用 A 这个泛型类
 * @param <T>
 */
public class A<T> {
    T value;

    public A(T value) {
        this.value = value;
    }

    T get() {
        return value;
    }

    public static void main(String[] args) {
        A<String> testA = new A<>("This is a test!");
        System.out.println(testA.get());
    }
}
