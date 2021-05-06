package ADVANCED.LAB19_ITERATORS_AND_COMPARATORS.L02_Library_2;

import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.authors = Arrays.asList(authors);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.title, this.year, this.authors);
    }
}
