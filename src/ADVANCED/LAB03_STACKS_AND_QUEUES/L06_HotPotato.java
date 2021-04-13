package ADVANCED.LAB03_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentChild = queue.poll();
                queue.offer(currentChild);

            }
            System.out.println("Removed " + queue.poll());
        }

        System.out.println("Last is " + queue.poll());

    }
}
