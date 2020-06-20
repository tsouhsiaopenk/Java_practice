package Java6_13.review;

import org.junit.Test;

public class test {
    public static void main(String[] args) {
        String x = "fmn";
        x.toUpperCase();
        String y = x.replace('f','F');
        y = y + "wxy";
        System.out.println(y);
    }

    @Test
    public void test(){
        int i = 0;
        Integer j = new Integer(0);
        System.out.println(i == j);
        System.out.println(j.equals(i));
    }
}
