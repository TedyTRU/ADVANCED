package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class E02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");

        int N = Integer.parseInt(elements[0]);
        int S = Integer.parseInt(elements[1]);
        int X = Integer.parseInt(elements[2]);
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < (N - S); i++) {
            deque.push(numbers[i]);
        }

        if (deque.contains(X)) {
            System.out.println("true");

        } else {

            if (!deque.isEmpty()) {
//                int smallestNumber = Integer.MAX_VALUE;
//                for (Integer integer : deque) {
//                    if (integer < smallestNumber) {
//                        smallestNumber = integer;
//                    }
//                }
                Integer minElement = Collections.min(deque);
                System.out.println(minElement);

            } else {
                System.out.println(0);
            }
        }
    }
}
