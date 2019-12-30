import java.util.Scanner;

public class Login {
    /*
        编写代码模拟三次密码输入的场景。
        最多能输入三次密码，密码正确，提示“登录成功”,
        密码错误， 可以重新输入，最多输入三次。
        三次均错，则提示退出程序
     */
    public static void main(String[] args) {
        String password = "admin";
        Scanner scanner =new Scanner(System.in);
        int step = 3;
        while(step!=0){
            String string = scanner.nextLine();
            if(string.equals(password)){
                System.out.println("登陆成功");
                break;
            }else{
                System.out.println("密码错误，请重新登陆！");
                step--;
            }
        }
        System.exit(1);
    }
}
