package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class E04_AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> addOne = arr -> Arrays.stream(arr).map(num -> (num + 1)).toArray();
        Function<int[], int[]> multiplyByTwo = arr -> Arrays.stream(arr).map(num -> num * 2).toArray();
        Function<int[], int[]> subtractOne = arr -> Arrays.stream(arr).map(num -> num - 1).toArray();

        Consumer<int[]> print = arr -> Arrays.stream(arr).forEach(e -> System.out.printf("%d ", e));

        String tokens = scanner.nextLine();

        while (!"end".equals(tokens)) {

            if ("add".equals(tokens)) {
                numbers = addOne.apply(numbers);

            } else if ("multiply".equals(tokens)) {
                numbers = multiplyByTwo.apply(numbers);

            } else if ("subtract".equals(tokens)) {
                numbers = subtractOne.apply(numbers);

            } else if ("print".equals(tokens)) {
                print.accept(numbers);
                System.out.println();

            }

            tokens = scanner.nextLine();
        }

    }
}
