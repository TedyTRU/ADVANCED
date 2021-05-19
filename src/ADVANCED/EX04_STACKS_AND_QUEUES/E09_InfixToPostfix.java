package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Scanner;

public class E09_InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        ArrayDeque<String> numbersQueue = new ArrayDeque<>();
        ArrayDeque<String> operatorStack = new ArrayDeque<>();

        for (String token : tokens) {

            if (Character.isDigit(token.charAt(0)) || Character.isLetter(token.charAt(0))) {
                numbersQueue.offer(token);

            } else {
                if (operatorStack.isEmpty()) {
                    operatorStack.push(token);

                } else {
                    String lastOperator = operatorStack.peek();

                    switch (token) {
                        case "+":
                        case "-":

                            if (!lastOperator.equals("(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            operatorStack.push(token);
                            break;

                        case "*":
                        case "/":
                            if (lastOperator.equals("*") || lastOperator.equals("/")) {
                                numbersQueue.offer(operatorStack.pop());
                            }

                            operatorStack.push(token);
                            break;

                        case "(":
                            operatorStack.push(token);
                            break;
                        case ")":
                            while (!Objects.equals(operatorStack.peek(), "(")) {
                                numbersQueue.offer(operatorStack.pop());
                            }
                            // Removing the non-necessary open parenthesis '('
                            operatorStack.pop();
                            break;
                    }
                }
            }
        }

        while (!numbersQueue.isEmpty()) {
            System.out.print(numbersQueue.poll() + " ");
        }

        while (!operatorStack.isEmpty()) {
            System.out.print(operatorStack.pop() + " ");
        }

    }
}
