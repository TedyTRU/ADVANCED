package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class L02_SumNumbers_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Function<String, IntStream> getIntStream = str ->
                Arrays.stream(str.split(", "))
                .mapToInt(Integer::parseInt);

        Function<String, Long> getCount = str -> {
            return getIntStream.apply(str)
                    .count();
        };

        Function<String, Integer> getSum = str -> {
            return getIntStream.apply(str)
                    .sum();
        };

        System.out.printf("Count = %d%n", getCount.apply(input));
        System.out.printf("SUm = %d", getSum.apply(input));

    }
}
