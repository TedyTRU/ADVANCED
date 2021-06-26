package ADVANCED.EXAMS.EXAM_9;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01_OS_Planing {

    public static int winner;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int value = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            int taskValue = tasks.peek();
            int threadValue = threads.peek();

            if (taskValue != value) {
                if (threadValue >= taskValue) {
                    threads.poll();
                    tasks.pop();

                } else {
                    threads.poll();
                }

            } else {
                winner = threadValue;
                break;
            }

        }

        System.out.printf("Thread with value %d killed task %d%n", winner, value);

        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));

    }
}
