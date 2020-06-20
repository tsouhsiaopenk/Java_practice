package Java6_16.review;

import org.junit.Test;

public class Test2 {
    public void add(Byte b){
        b = b++;
    }
    @Test
    public void test(){
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.println(a + " ");
        add(b);
        System.out.println(b + " ");
    }
}
