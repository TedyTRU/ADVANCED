package ADVANCED.EXAMS.EXAM_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_DatingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> males = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .filter(male -> male > 0)
                .forEach(males::push);

        ArrayDeque<Integer> females =
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(female -> female > 0)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!males.isEmpty() && !females.isEmpty()) {

            if (males.peek() % 25 == 0) {
                for (int i = 0; i < 2; i++) {
                    if (!males.isEmpty()) {
                        males.pop();
                    }
                }
                continue;
            }

            if (females.peek() % 25 == 0) {
                for (int i = 0; i < 2; i++) {
                    if (!females.isEmpty()) {
                        females.poll();
                    }
                }
                continue;
            }

            if (males.peek() == females.peek()) {
                males.pop();
                females.poll();
                matches++;

            } else {
                females.poll();
                int decrease = males.pop() - 2;
                if (decrease > 0) {
                    males.push(decrease);
                }

            }

        }
        System.out.printf("Matches: %d%n", matches);

        System.out.println(males.isEmpty() ? "Males left: none"
                : String.format("Males left: %s",
                males.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "))));

        System.out.println(females.isEmpty() ? "Females left: none"
                : String.format("Females left: %s",
                females.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "))));

    }
}
