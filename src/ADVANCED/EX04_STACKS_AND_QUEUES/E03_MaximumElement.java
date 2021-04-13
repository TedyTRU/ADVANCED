package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class E03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String command = line[0];

            if (command.equals("1")) {
                int element = Integer.parseInt(line[1]);
                deque.push(element);

            } else if (command.equals("2")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }

            } else if (command.equals("3")) {
                if (!deque.isEmpty()) {
                    Integer maxElement = Collections.max(deque);
                    System.out.println(maxElement);
                }
            }
        }
    }
}
