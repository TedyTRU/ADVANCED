package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.Scanner;

public class E07_RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long[] fibonacci = new long[51];

        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i = 2; i < 51; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(fibonacci[n]);

    }
}
