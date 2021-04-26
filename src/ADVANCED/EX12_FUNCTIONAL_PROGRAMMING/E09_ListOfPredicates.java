package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class E09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
//        Set<Integer> numbersSet = Arrays.stream (scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());

        Set<Integer> numbersSet = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(HashSet::new));

        Predicate<Integer> isDivisible = num -> {
            for (Integer divisible : numbersSet) {
                if (num % divisible != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= number; i++) {
            if (isDivisible.test(i)) {
                System.out.print(i + " ");
            }
        }

    }
}
