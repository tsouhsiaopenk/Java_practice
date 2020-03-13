package Java3_13.action;

import Java3_13.book.Book;
import Java3_13.book.BookList;

import java.util.Scanner;

public class DelAction implements IAction{
    @Override
    public void work(BookList bookList) {
        /*
        删除图书的思路：循环遍历，若找到则记下位置，否则删除失败
        如果找到，这里简单处理，将最后一个书籍挪到要删除的位置，然后size--
         */
        System.out.println("删除图书");
        Scanner scanner = new Scanner(System.in);
        System.out.print("请删除要删除书籍的书名：");
        String name = scanner.next();
        // 1，先找到图书,找到的图书即为下标为i的图书
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)){
                break;
            }
        }
        if (i >= bookList.getSize()){
            System.out.println("没有找到能够匹配的书籍，删除失败！");
            return;
        }
        // 将最后一本图书，移动到i的位置
        int size = bookList.getSize();
        Book book = bookList.getBook(size-1);
        bookList.setBook(book,i);
        bookList.setSize(size-1);
        System.out.println("删除成功！");
    }
}
