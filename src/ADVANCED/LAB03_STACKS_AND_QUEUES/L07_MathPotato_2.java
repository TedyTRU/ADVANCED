package ADVANCED.LAB03_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class L07_MathPotato_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> kids = Arrays.stream(scan.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int transfers = Integer.parseInt(scan.nextLine());

        int cycle = 1;
        while (kids.size() > 1) {
            IntStream.range(1, transfers).forEach(i -> kids.offer(Objects.requireNonNull(kids.poll())));
            if (isPrime(cycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                System.out.println("Removed " + kids.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + kids.poll());

    }

    private static boolean isPrime(int cycle) {
        if (cycle == 1) {
            return false;
        }
        for (int i = 2; i <= cycle / 2; i++) {
            if (cycle % i == 0) {
                return false;
            }
        }
        return true;
    }
}