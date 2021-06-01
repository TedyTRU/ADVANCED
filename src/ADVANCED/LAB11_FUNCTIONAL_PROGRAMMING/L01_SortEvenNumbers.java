package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(number -> number % 2 != 0);

        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        numbers.sort(Integer::compareTo);

        System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(", ")));

    }
}
