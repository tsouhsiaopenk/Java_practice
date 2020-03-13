package Java3_13.user;

import Java3_13.action.*;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name) {
        this.name = name;
        actions = new IAction[]{
                new ExitAction(),
                new FIndAction(),
                new BorrowAction(),
                new ReturnAction()
        };
    }

    @Override
    public int menu() {
        int choice;
        System.out.println("====================");
        System.out.println("欢迎" + name + "使用图书馆管理系统");
        System.out.println("1,查找书籍");
        System.out.println("2,借书");
        System.out.println("3,还书");
        System.out.println("0,退出");
        System.out.println("====================");
        System.out.println("请输入您的选择：");
        Scanner scanner = new Scanner(System.in);
        do {
            choice = scanner.nextInt();
        } while (choice < 0 || choice > 3) ;
        return choice;
    }
}
