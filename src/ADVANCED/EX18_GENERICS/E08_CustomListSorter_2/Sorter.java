package ADVANCED.EX18_GENERICS.E08_CustomListSorter_2;

import java.util.Collections;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> list) {
        Collections.sort(list.toSort());
    }

}
