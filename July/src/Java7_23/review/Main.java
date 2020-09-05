package Java7_23.review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String symbol = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String number = "222333444555666777788899991234567890";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String str = scanner.next();
                str = str.replace("-", "");
                StringBuilder result = new StringBuilder();
                for (int j = 0; j < 7; j++) {
                    result.append(number.charAt(symbol.indexOf(str.charAt(j))));
                }
                result = new StringBuilder(result.substring(0, 3) + "-" + result.substring(3));
                if (!arrayList.contains(result.toString())){
                    arrayList.add(result.toString());
                }
            }
            // 每一组按照字典序输出不重复的标准形式电话号码
            Collections.sort(arrayList);
            for (String s : arrayList) {
                System.out.println(s);
            }
            System.out.println();
        }

    }
}
