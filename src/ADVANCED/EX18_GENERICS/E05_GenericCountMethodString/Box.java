package ADVANCED.EX18_GENERICS.E05_GenericCountMethodString;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> values;

    public Box() {
        this.values = new ArrayList<>();
    }

    public void add(T object) {
        this.values.add(object);
    }

    public long countGreaterValues(T object) {
        //       int greaterValues = 0;
//        for (T value : this.values) {
//           if (value > object) {
//               greaterValues++;
//           }
//        }

        long count = this.values.stream()
                .filter(e -> e.compareTo(object) > 0).count();
        return count;
    }

}
