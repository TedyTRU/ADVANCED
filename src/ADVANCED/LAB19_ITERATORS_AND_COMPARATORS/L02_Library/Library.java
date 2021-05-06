package ADVANCED.LAB19_ITERATORS_AND_COMPARATORS.L02_Library;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

//    public void forEach(Consumer <Book> consumer) {
//        for (int i = 0; i < books.length; i++) {
//            Book book = books[i];
//            consumer.accept(book);
//        }
//    }


    @Override
    public Iterator<Book> iterator() {

        Iterator<Book> bookIterator = new Iterator<Book>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < books.length;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };
        return bookIterator;
    }
}
