package ADVANCED.EX18_GENERICS.E06_GenericCountMethodDouble;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {

    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void addElement(T object) {
        this.values.add(object);
    }

    public long countGreaterValues(T object) {
        return this.values.stream()
                .filter(e -> e.compareTo(object) == 1)
                .count();
    }

}
