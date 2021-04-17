package ADVANCED.EX08_SETS_AND_MAPS_ADVANCED;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class E02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengths = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int n = lengths[0];
        int m = lengths[1];

        Set<Integer> setOfNumbers = new LinkedHashSet<>();
        Set<Integer> nonRepeatingNumbers = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            setOfNumbers.add(number);
        }

        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (setOfNumbers.contains(number)) {
                nonRepeatingNumbers.add(number);
            }
        }

        nonRepeatingNumbers.forEach(System.out::println);

    }
}
