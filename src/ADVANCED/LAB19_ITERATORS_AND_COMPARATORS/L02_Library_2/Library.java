package ADVANCED.LAB19_ITERATORS_AND_COMPARATORS.L02_Library_2;

import java.util.Iterator;

public class Library implements Iterable<Book> {

    private class LibraryIterator implements Iterator<Book>{

        private int index = 0;

        @Override
        public  boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }
}
