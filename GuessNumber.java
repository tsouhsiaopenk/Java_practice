import com.sun.prism.shader.Texture_ImagePattern_AlphaTest_Loader;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void menu(){
        System.out.println("欢迎来猜数字");
        System.out.println("************************");
        System.out.println("1,开始猜数字");
        System.out.println("2,退出");
    }
    public static void guessNumber(){
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        Random random = new Random();
        int digit = random.nextInt(100);
        while(true){
            if(number == digit){
                System.out.println("你赢了");
                break;
            }
            if(number<digit){
                System.out.println("猜小了");
            }
            if(number>digit){
                System.out.println("猜大了");
            }
            number = scanner.nextInt();
        }
    }
    public static void main(String[] args) {
        // 先显示菜单
        menu();
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        if(choose == 1){
            guessNumber();
        }
        else {
            //正常退出
            System.exit(0);
        }
    }
}
