package cn.sher6j.designpattens.IteratorPatten;

/**
 * @author sher6j
 * @create 2020-10-29-15:14
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        bookShelf.appendBook(new Book("Bible"));
        bookShelf.appendBook(new Book("Around the World in 80 Days"));
        bookShelf.appendBook(new Book("Design Pattens"));
        bookShelf.appendBook(new Book("Computer Network"));
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
