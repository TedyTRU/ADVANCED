package ADVANCED.EX04_STACKS_AND_QUEUES;

import java.util.ArrayDeque;
import java.util.Scanner;

public class E08_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String command = commands[0];

            if (command.equals("1")) {
                String string = commands[1];
                stack.push(text.toString());
                text.append(string);

            } else if (command.equals("2")) {
                int count = Integer.parseInt(commands[1]);
                int startIndex = text.length() - count;

                stack.push(text.toString());
                text.delete(startIndex, text.length());

            } else if (command.equals("3")) {
                int index = Integer.parseInt(commands[1]);

                System.out.println(text.toString().charAt(index - 1));

            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    text = new StringBuilder(stack.pop());
                }
            }
        }
    }
}
