package ADVANCED;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {

        System.out.println(getOperatCount(1));

    }
    public static long getOperatCount(int n) {

        long counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                counter++;
            }
        }
        return counter;
    }
}

