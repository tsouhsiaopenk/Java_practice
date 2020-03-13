package Java3_13.user;

import Java3_13.action.*;

import java.util.Scanner;

public class Admin extends User{
    public Admin(String name) {
        this.name = name;
        actions = new IAction[]{
                new ExitAction(),
                new AddAction(),
                new DelAction(),
                new FIndAction(),
                new DisplayAction()
        };
    }

    @Override
    public int menu() {
        int choice;
        System.out.println("=======================");
        System.out.println("欢迎使用图书馆管理系统，"+this.name+"您是管理员");
        System.out.println("1，新增图书");
        System.out.println("2，删除图书");
        System.out.println("3，查找图书");
        System.out.println("4，显示所有书籍");
        System.out.println("0，退出");
        System.out.println("=======================");
        Scanner scanner = new Scanner(System.in);
        do {
            // 循环输入
            choice = scanner.nextInt();
        }while (choice < 0 || choice> 4);
        return choice;
    }
}
