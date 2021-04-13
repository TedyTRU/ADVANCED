package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E06_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] sequence = scanner.nextLine().toCharArray();
        ArrayDeque<Character> parentheses = new ArrayDeque<>();
        boolean isBalanced = true;

        for (char current : sequence) {
            if ('(' == current) {
                parentheses.push(')');

            } else if ('[' == current) {
                parentheses.push(']');

            } else if ('{' == current) {
                parentheses.push('}');

            } else if (')' == current || ']' == current || '}' == current) {
                if (parentheses.isEmpty() || current != parentheses.pop()) {
                    isBalanced = false;
                }
            }
            if (!isBalanced) {
                break;
            }
        }

        isBalanced &= parentheses.isEmpty();

        System.out.println(isBalanced ? "YES" : "NO");

    }
}
