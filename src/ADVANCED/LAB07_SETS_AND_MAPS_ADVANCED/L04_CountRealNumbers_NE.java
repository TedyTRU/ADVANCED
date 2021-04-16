package ADVANCED.LAB07_SETS_AND_MAPS_ADVANCED;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L04_CountRealNumbers_NE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Arrays.stream(scanner.nextLine().split("\\s+"))
//                .map(Double::parseDouble)
//                .collect(Collectors.toMap(e -> e, e -> Collectors.counting()))
//                .forEach((key, value) -> System.out.printf("%.1f -> %d%n", key, value));


        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toMap(s -> s, s -> 0, (a, b) -> a, LinkedHashMap::new))
                .forEach((k, v) -> System.out.printf("%.1f -> %d%n", k, v));




    }
}
