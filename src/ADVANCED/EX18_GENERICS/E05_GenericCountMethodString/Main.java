package ADVANCED.EX18_GENERICS.E05_GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> boxes = new Box<>();

        while (n-- > 0) {
            String line = scanner.nextLine();
            boxes.add(line);
        }

        String compareValue = scanner.nextLine();

        System.out.println(boxes.countGreaterValues(compareValue));

    }
}
