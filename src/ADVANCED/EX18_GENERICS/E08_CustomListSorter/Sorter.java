package ADVANCED.EX18_GENERICS.E08_CustomListSorter;

public class Sorter {
    public static <E extends Comparable<E>> void sort(CustomList<E> list) {

        for (int i = 0; i < list.size(); i++) {
            E currentEl = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (currentEl.compareTo(list.get(j)) > 0) {
                    list.swap(i, j);
                }
            }
        }
    }

}
