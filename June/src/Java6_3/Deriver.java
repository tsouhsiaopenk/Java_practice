package Java6_3;
class Base{
    public Base(String s){
        System.out.println("B");
    }
}
public class Deriver extends Base{

    public Deriver(String s) {
        super(s);
        System.out.println("D");
    }

    public static void main(String[] args) {
        new Deriver("C");
    }
}
