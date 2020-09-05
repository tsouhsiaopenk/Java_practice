package Java7_9.Test;

import org.junit.Test;

public class test {
    private static final double R = 3;

    public static void main(String[] args) {
        System.out.println((4.0/3)*Math.PI*Math.pow(R,3));
        System.out.println(4*Math.PI*Math.pow(R,3)/3);
    }

    @Test
    public void t1(){
        System.out.println(4.0/3);
    }
}
