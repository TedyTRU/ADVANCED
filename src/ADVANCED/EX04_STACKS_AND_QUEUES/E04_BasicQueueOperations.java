package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] command = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = command[0];
        int S = command[1];
        int X = command[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = S; i < N; i++) {
            queue.offer(numbers[i]);
        }

        if (queue.contains(X)) {
            System.out.println("true");

        } else {
            if (!queue.isEmpty()) {
                Integer smallestElement = Collections.min(queue);
                System.out.println(smallestElement);
            } else {
                System.out.println(0);
            }
        }
    }
}
