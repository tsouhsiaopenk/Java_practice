package Java3_9;

import Java3_9.book.BookList;
import Java3_9.user.NormalUser;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 先把数据准备好
        BookList bookList = new BookList();
        // 创建用户，并进行登陆
        NormalUser user = login();
        while(true){
            int choice = user.menu();
            user.doAction(choice,bookList);
        }
    }

    public static NormalUser login(){
        // 提示用户进行登陆
        Scanner scanner = new Scanner(System.in);
        System.out.println("请登录系统！！！！");
        System.out.println("请输入您的姓名：");
        String name = scanner.next();
        System.out.println("请输入您的身份：1表示管理员 2表示普通用户");
        int who = scanner.nextInt();
        return new NormalUser(name);
    }
}
