package Java3_13.action;

import Java3_13.book.Book;
import Java3_13.book.BookList;

import java.util.Scanner;

public class AddAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("新增书籍");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入书名：");
        String name = scanner.next();
        System.out.print("请输入作者:");
        String author = scanner.next();
        System.out.print("请输入价钱:");
        int price = scanner.nextInt();
        System.out.print("请输入种类:");
        String type = scanner.next();
        // 将借出状态默认为false，即没有借出
        Book book = new Book(name, author, price, type, false);
        // 此处暂时不考虑扩容操作，直接进行尾插操作
        int size = bookList.getSize();
        bookList.setBook(book, size);
        bookList.setSize(size + 1);
        System.out.println("新增图书成功！");
    }
}
