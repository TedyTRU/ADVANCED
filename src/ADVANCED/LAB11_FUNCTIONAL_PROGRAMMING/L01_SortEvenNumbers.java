package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(Math::isEven)   // .filter(n -> isEven(n))
                .toArray();

        System.out.println(formatArray(numbers));

        Arrays.sort(numbers);

        System.out.println(formatArray(numbers));

    }

    public static String formatArray(int[] arr) {
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
    }

}
