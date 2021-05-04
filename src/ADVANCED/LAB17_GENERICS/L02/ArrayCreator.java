package ADVANCED.LAB17_GENERICS.L02;

import java.lang.reflect.Array;
import java.util.Objects;

public class ArrayCreator<T> {

    @SuppressWarnings("unchecked")
    public static <T> T[] createArray(int length, T item) {
        //T [] arr = (T[]) new Objects[length];
        T[] arr = (T[]) Array
                .newInstance( item.getClass(), length);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }


}
