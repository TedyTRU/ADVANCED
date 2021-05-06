package ADVANCED.LAB19_ITERATORS_AND_COMPARATORS.L02_Library;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        Library library = new Library(new Book("Fox", 13),
                new Book("The", 42),
                new Book("Quick", 73));

        for (Book book : library) {
            System.out.println(book);
        }

        library.forEach(b -> System.out.println(b));

    }
}
