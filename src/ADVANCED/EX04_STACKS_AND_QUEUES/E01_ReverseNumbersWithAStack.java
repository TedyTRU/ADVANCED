package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int number : numbers) {
            deque.push(number);
        }

        for (Integer integer : deque) {
            System.out.print(integer + " ");
        }

    }
}
