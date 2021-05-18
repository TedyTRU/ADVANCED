package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.Scanner;

public class E07_RecursiveFibonacci_2 {

    private static long[] memo;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        memo = new long[n + 1];

        //recursiveFibonacci(n);
        System.out.println(recursiveFibonacciWithMemoization(n));
    }

    // Recursive fibonacci without DP
    private static long recursiveFibonacci(int n) {

        if (n <= 1) {
            return 1;
        }
        return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
    }

    // Top down DP: recursion + memoization
    private static long recursiveFibonacciWithMemoization(int n) {

        if (n <= 1) {
            return 1;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = recursiveFibonacciWithMemoization(n - 1) +
                recursiveFibonacciWithMemoization(n - 2);

        return memo[n];
    }

}
