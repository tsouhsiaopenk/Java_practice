package Java7_6.OJ;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            // 按照空格进行划分
            String[] strings = string.split(" ");

            for(int i = strings.length - 1;i >= 0 ;i--){
                System.out.print(strings[i]);
                if(i > 0){
                    System.out.print(" ");
                }
            }
        }
    }
}
