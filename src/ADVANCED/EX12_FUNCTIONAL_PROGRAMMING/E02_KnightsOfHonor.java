package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class E02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> consumer = name -> System.out.printf("Sir %s%n", name);

        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(consumer);

    }
}
