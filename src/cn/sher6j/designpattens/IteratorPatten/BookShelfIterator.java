package cn.sher6j.designpattens.IteratorPatten;

/**
 * @author sher6j
 * @create 2020-10-29-15:11
 */
public class BookShelfIterator implements Iterator {

    private BookShelf bookShelf;
    private int idx;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.idx = 0;
    }

    @Override
    public boolean hasNext() {
        if (idx < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * return current element and advance to next position
     * @return
     */
    @Override
    public Object next() {
        Book book = bookShelf.getBookAt(idx);
        idx++;
        return book;
    }
}
