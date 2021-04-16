package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.*;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> numbers = new HashSet<>();


        boolean added = numbers.add(13);
        System.out.println(added);
        added = numbers.add(13);
        System.out.println(added);


        Map<String, Integer> map = new HashMap<>();

        for (String s : map.keySet()) {

        }



    }
}
