package ADVANCED.LAB03_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class L04_Matching_Brackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.nextLine();

        ArrayDeque<Integer> indexesOfOpeningBrackets = new ArrayDeque<>();

        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);

            if (symbol == '(') {
                indexesOfOpeningBrackets.push(i);
            } else if (symbol == ')') {
                System.out.println(expression.substring(indexesOfOpeningBrackets.pop(), i + 1));
            }
        }
    }
}
