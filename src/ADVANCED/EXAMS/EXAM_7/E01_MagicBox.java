package ADVANCED.EXAMS.EXAM_7;

import java.util.*;
import java.util.stream.Collectors;

public class E01_MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(secondBox::push);

        List<Integer> claimedItems = new ArrayList<>();

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int firstBoxItem = firstBox.peek();
            int secondBoxItem = secondBox.peek();
            int sum = firstBoxItem + secondBoxItem;

            if (sum % 2 == 0) {
                firstBox.poll();
                secondBox.pop();
                claimedItems.add(sum);

            } else {
                firstBox.offer(secondBox.pop());

            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");

        } else {
            System.out.println("Second magic box is empty.");
        }

        int sum = claimedItems.stream().mapToInt(s -> s).sum();

        if (sum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", sum);

        } else {
            System.out.printf("Poor prey... Value: %d", sum);
        }

    }
}
