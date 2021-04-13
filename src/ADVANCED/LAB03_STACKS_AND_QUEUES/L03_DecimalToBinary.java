package ADVANCED.LAB03_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> binaryRepresentation = new ArrayDeque<>();

        if (n == 0) {
            System.out.println(0);
        } else {
            while (n > 0) {
                int digit = n % 2;
                binaryRepresentation.push(digit);
                n /= 2;
            }
        }
        for (Integer integer : binaryRepresentation) {
            System.out.print(integer);
        }
    }
}
