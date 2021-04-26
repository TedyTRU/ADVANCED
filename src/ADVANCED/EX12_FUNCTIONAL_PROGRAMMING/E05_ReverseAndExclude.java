package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        Collections.reverse(numbers);

        // var.1
//        Predicate<Integer> predicate = e -> e % n != 0;
//        numbers.stream().filter(e -> predicate.test(e))
//                .forEach(e -> System.out.print(e + " "));


        // var.2
        Predicate<Integer> predicate = e -> e % n != 0;
        Function<List<Integer>, List<Integer>> excludeFunc = list -> list.stream()
                .filter(predicate).collect(Collectors.toList());

        numbers = excludeFunc.apply(numbers);
        Consumer<Integer> consumer = e -> System.out.print(e + " ");
        numbers.forEach(consumer);


        //var.3
//        numbers.stream().filter(e -> e % n != 0)
//                .forEach(e -> System.out.print(e + " "));

    }
}
