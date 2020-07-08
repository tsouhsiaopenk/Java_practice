package Java7_8.OJ;

import org.junit.Test;

import java.util.Scanner;

public class Solution {
    private static double PI = Math.acos(-1);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double z0 = scanner.nextDouble();
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            double R = getRadius(x0,y0,z0,x1,y1,z1);
            double V = getVolume(R);
            System.out.printf("%.3f %.3f",R,V);
        }
    }

    private static double getVolume(double R) {
        return 4.0/3*PI*Math.pow(R,3);
    }

    private static double getRadius(double x0, double y0, double z0, double x1, double y1, double z1) {
        return Math.sqrt((x0-x1)*(x0-x1)+(y0-y1)*(y0-y1)+(z0-z1)*(z0-z1));
    }


    @Test
    public void test(){
        System.out.println(getRadius(0,0,0,1,1,1));
        System.out.println(Math.pow(2,3));
    }
}
