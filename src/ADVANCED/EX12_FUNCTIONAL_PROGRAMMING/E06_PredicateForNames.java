package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class E06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());

        String[] names = scanner.nextLine().split("\\s+");

        Predicate<String> lessThanLength = name -> name.length() <= length;

        Arrays.stream(names).filter(lessThanLength)
                .forEach(e -> System.out.println(e));

    }
}
