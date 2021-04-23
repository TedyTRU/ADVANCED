package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class L02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        IntStream numbers = Arrays.stream(scanner.nextLine().split(", "))
//                .mapToInt(Integer::parseInt);
//
//        long count = numbers.count();
//        int sum = numbers.sum();
//
//        System.out.printf("Count = %d", count);
//        System.out.printf("Sum = %d", sum);

        String input = scanner.nextLine();

        Function<String, Long> getCount = str -> {
            return Arrays.stream(str.split(", "))
                    .mapToInt(Integer::parseInt)
                    .count();
        };

        Function<String, Integer> getSum = str -> {
            return Arrays.stream(str.split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        };


        System.out.printf("Count = %d%n", getCount.apply(input));
        System.out.printf("SUm = %d", getSum.apply(input));

    }
}
