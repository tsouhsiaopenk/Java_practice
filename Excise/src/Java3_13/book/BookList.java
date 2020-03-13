package Java3_13.book;

// 用来表示多本书
public class BookList {
    // 相当于一个顺序表
    private Book[] books = new Book[100];
    private int size = 0;

    public BookList() {
        // 先添加几个数据进去，方便后续测试
        books[0] = new Book("三国演义", "罗贯中", 100, "古典名著",
                false);
        books[1] = new Book("西游记", "吴承恩", 120, "古典名著",
                false);
        books[2] = new Book("金瓶梅", "兰陵笑笑生", 200, "古典名著",
                false);
        size = 3;
    }

    public Book getBook(int pos) {
        return books[pos];
    }

    public void setBook(Book book, int pos) {
        books[pos] = book;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
