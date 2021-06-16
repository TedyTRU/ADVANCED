package ADVANCED.EX18_GENERICS.E08_CustomListSorter_2;

import java.util.*;

public class CustomList<T extends Comparable<T>> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public List<T> toSort() {
        return this.data;
    }

    public void add(T object) {
        this.data.add(object);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T object) {
        return this.data.contains(object);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.data, index1, index2);
    }

    public long countGreaterThan(T element) {
        return this.data.stream()
                .filter(e -> e.compareTo(element) > 0)
                .count();
    }

    public T getMax() {
        return this.data.stream()
                .max(Comparator.naturalOrder()).orElse(null);
    }

    public T getMin() {
        return this.data.stream()
                .min(Comparator.naturalOrder()).orElse(null);
    }

    public void print() {
        this.data.forEach(System.out::println);
    }

}
