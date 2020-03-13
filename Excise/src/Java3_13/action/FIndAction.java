package Java3_13.action;

import Java3_13.book.Book;
import Java3_13.book.BookList;

import java.util.Scanner;

public class FIndAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行查找图书操作");
        System.out.println("请输入要查找的书籍名字：");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)){
                System.out.println(book);
                System.out.println("查找完成");
            }
        }
    }
}
