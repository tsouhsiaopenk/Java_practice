package Java3_13;

import Java3_13.book.BookList;
import Java3_13.user.Admin;
import Java3_13.user.NormalUser;
import Java3_13.user.User;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // 创建数据（这个程序，本身无法存储或加载数据）
        BookList bookList = new BookList();
        // 创建用户，并进行登陆
        User user = login();
        // 进入循环
        while(true){
            // 子类和父类均有次此方法，构成了重写
            int choice = user.menu();
            user.doAction(choice,bookList);
        }
    }

    public static User login(){
        // 提示用户进行登陆
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录系统！！！！");
        System.out.println("请输入您的姓名：");
        String name = scanner.next();
        System.out.println("请输入您的身份：1表示管理员 2表示普通用户");
        int who = scanner.nextInt();
        if (who == 1){
            return new Admin(name);
        }
        return new NormalUser(name);
    }
}
