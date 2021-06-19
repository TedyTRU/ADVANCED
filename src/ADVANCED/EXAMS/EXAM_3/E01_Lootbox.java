package ADVANCED.EXAMS.EXAM_3;

import java.util.*;
import java.util.stream.Collectors;

public class E01_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLootBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondLootBox::push);


        int claimedItemsSum = 0;
        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()) {
            int sum = firstLootBox.peek() + secondLootBox.peek();
            if (sum % 2 == 0) {
                claimedItemsSum += sum;
                firstLootBox.poll();
                secondLootBox.pop();

            } else {
                firstLootBox.offer(secondLootBox.pop());
            }

        }

        if (firstLootBox.isEmpty()) {
            System.out.println("First lootbox is empty");

        } else {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItemsSum >= 100) {
            System.out.println("Your loot was epic! Value: " + claimedItemsSum);

        } else {
            System.out.println("Your loot was poor... Value: " + claimedItemsSum);
        }

    }
}
