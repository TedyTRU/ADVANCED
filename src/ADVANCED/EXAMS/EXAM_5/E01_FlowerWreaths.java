package ADVANCED.EXAMS.EXAM_5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreaths = 0;
        int sumFlowers = 0;

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            int lily = lilies.pop();
            int rose = roses.poll();
            int crafting = lily + rose;

            if (crafting > 15) {
                while (crafting > 15) {
                    lily -= 2;
                    crafting = lily + rose;
                }
            }

            if (crafting == 15) {
                wreaths++;

            } else {
                sumFlowers += crafting;

            }
        }

        wreaths += sumFlowers / 15;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }

    }
}
