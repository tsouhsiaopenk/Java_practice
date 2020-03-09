package Java3_9.action;

import Java3_9.book.Book;
import Java3_9.book.BookList;

import java.util.Scanner;

public class BorrowAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("执行结束操作");
        System.out.println("请输入你要借的书籍的书名：");
        Scanner sanner = new Scanner(System.in);
        String name = sanner.next();
        // 找到要接的书，然后将书的状态改成“借出”状态即可
        for (int i = 0; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                if (book.isBorrowed()) {
                    continue;
                } else {
                    book.setBorrowed(true);
                    System.out.println("借书成功！");
                    return;
                }
            }

        }
        System.out.println("借书失败！没有匹配的书籍！");
    }
}
