package ADVANCED.LAB03_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        int cycle = 1;
        while (queue.size() > 1) {
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());

            if (isPrime(cycle))
                System.out.println("Prime " + queue.peek());
            else
                System.out.println("Removed " + queue.poll());

            cycle++;
        }

        System.out.println("Last is " + queue.poll());
    }


    private static boolean isPrime(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
}
