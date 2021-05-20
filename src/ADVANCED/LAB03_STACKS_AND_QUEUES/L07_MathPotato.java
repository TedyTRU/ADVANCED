package ADVANCED.LAB03_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> hotPotato = new ArrayDeque<>();

        for (String child : children) {
            hotPotato.offer(child);
        }

        int cycle = 0;
        while (hotPotato.size() > 1) {

            cycle++;
            for (int i = 1; i < n; i++) {

                hotPotato.offer(hotPotato.poll());
            }
            if (isComposite(cycle)) {
                System.out.println("Removed " + hotPotato.poll());

            } else {
                System.out.println("Prime " + hotPotato.peek());
            }

        }

        System.out.println("Last is " + hotPotato.peek());
    }

    private static boolean isComposite(int n) {

        if (n == 1) {
            return true;
        }

        if ((n % 2 == 0 || n % 3 == 0 || n % 5 == 0) && n != 2 && n != 3 && n != 5) {
            return true;

        }
        return false;
    }
}
