package Java6_3;

public class Person {
    private String name = "Person";
    int age = 0;
}
class Child extends Person{
    public String grade;

    public static void main(String[] args) {
        Person p = new Child();
        //System.out.println(p.name);
    }
}
