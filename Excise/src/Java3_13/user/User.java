package Java3_13.user;


import Java3_13.action.IAction;
import Java3_13.book.BookList;

abstract public class User {
    protected String name = null;
    protected IAction[] actions = null;

    abstract public int menu();

    public void doAction(int choice, BookList bookList) {
        this.actions[choice].work(bookList);
    }
}
