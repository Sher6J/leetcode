package cn.sher6j.designpattens.IteratorPatten;

/**
 * @author sher6j
 * @create 2020-10-29-15:08
 */
public class BookShelf implements Aggregate{

    private Book[] books;
    private int last = 0;

    /**
     * 构造书架
     * @param maxSize 书架最大容量
     */
    public BookShelf(int maxSize) {
        this.books = new Book[maxSize];
    }

    public Book getBookAt(int idx) {
        return books[idx];
    }

    public void appendBook(Book book) {
        this.books[last] = book;
        last++;
    }

    public int getLength() {
        return last;
    }

    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
