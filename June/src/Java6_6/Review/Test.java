package Java6_6.Review;

import java.util.jar.JarOutputStream;

public class Test {
//    public int aMethod() {
//        static int i =0;
//        i++;
//        return i;
//    }

    public Test() {
    }
    public  int Test(){
        return 1+2;
    }
    public static void main(String[] args) {

        Test test = new Test();
        System.out.println(test.Test());
//        test.aMethod();
//        int j = test.aMethod();
//        System.out.println(j);
    }


}
