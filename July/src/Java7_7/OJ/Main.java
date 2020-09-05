package Java7_7.OJ;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // 哈利·波特应付的钱
            String P = scanner.next();
            // 哈利·波特实际付的钱
            String A = scanner.next();
            // 找零钱
            Change(P, A);
            // 10.16.27 14.1.28
        }
    }
    // 找零钱
    private static void Change(String P, String A) {
        System.out.println(P);
        System.out.println(A);
        String[] pStr = P.split("\\.");
        String[] aStr = A.split("\\.");
        int Galleon = 0;
        int Sickle = 0;
        int Knut = 0;
        Galleon = Integer.parseInt(aStr[0]) - Integer.parseInt(pStr[0]);
        Sickle = Integer.parseInt(aStr[1]) - Integer.parseInt(pStr[1]);
        Knut = Integer.parseInt(aStr[2]) - Integer.parseInt(pStr[2]);
        if ((Galleon != 0 || Sickle != 0 || Knut >= 0) &&
                (Galleon != 0 || Sickle >= 0 || Knut >= 0) &&
                (Galleon >= 0 || Sickle >= 0 || Knut >= 0)) {
            if (Knut < 0) {
                Sickle--;
                Knut += 29;
            }
            if (Sickle < 0) {
                Galleon--;
                Sickle += 17;
            }
        }
        System.out.println(Galleon + "." + Sickle + "." + Knut);
    }

}
