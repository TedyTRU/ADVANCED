package ADVANCED.EX18_GENERICS.E07_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }

    public void add(T element) {
        this.data.add(element);
    }

    public T remove(int index) {
        return this.data.remove(index);
    }

    public boolean contains(T element) {
        return this.data.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.data.get(firstIndex);
        T secondElement = this.data.get(secondIndex);
        this.data.set(firstIndex, secondElement);
        this.data.set(secondIndex, firstElement);
        //Collections.swap(this.data, firstIndex, secondIndex);
    }

    public long countGreaterThan(T element) {
        return this.data.stream()
                .filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        T maxEl = this.data.get(0);
        for (T datum : this.data) {
            if (datum.compareTo(maxEl) > 0) {
                maxEl = datum;
            }
        }
        return maxEl;
        //return this.data.stream().max(Comparator.naturalOrder()).orElse(null);
    }

    public T getMin() {
        T minEl = this.data.get(0);
        for (T datum : this.data) {
            if (datum.compareTo(minEl) < 0) {
                minEl = datum;
            }
        }
        return minEl;
        //return this.data.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public void print() {
        this.data.forEach(System.out::println);
    }
}
