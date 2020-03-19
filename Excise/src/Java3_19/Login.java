package Java3_19;

import java.util.Scanner;

public class Login {
    public String name = "admin";
    public String password = "1234546";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String password = scanner.nextLine();
        Login login = new Login();
        try {
            if (!name.equals(login.name)) {
                throw new LoginException("用户名错误！");
            }
            if (!password.equals(login.password)) {
                throw new LoginException("密码错误!");
            }
            System.out.println("登陆成功！");
        } catch (LoginException e) {
            System.out.println(e.getMessage());
        }
    }
}
