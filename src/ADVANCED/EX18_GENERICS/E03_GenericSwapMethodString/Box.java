package ADVANCED.EX18_GENERICS.E03_GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T object) {
        this.values.add(object);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstEl = this.values.get(firstIndex);
        T secondEl = this.values.get(secondIndex);
        this.values.set(firstIndex, secondEl);
        this.values.set(secondIndex, firstEl);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T value : this.values) {
            sb
                    .append(String.format("%s: %s", value.getClass().getName(), value.toString()))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
