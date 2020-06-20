package Java6_18.review;
abstract class Animal{
    abstract void say();
}
public class Cat extends Animal{
    public Cat() {
        System.out.println("I am Cat");
    }

    public static void main(String[] args) {
        Cat cat = new Cat();
    }

    @Override
    void say() {

    }
}
