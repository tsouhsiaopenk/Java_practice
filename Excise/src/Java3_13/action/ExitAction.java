package Java3_13.action;

import Java3_13.book.BookList;

public class ExitAction implements IAction {
    @Override
    public void work(BookList bookList) {
        System.out.println("goodbye!!!");
        System.exit(0);
    }
}
