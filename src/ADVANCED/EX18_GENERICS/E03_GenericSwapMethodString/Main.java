package ADVANCED.EX18_GENERICS.E03_GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> boxes = new Box<>();

        while (n-- > 0) {
            String input = scanner.nextLine();

            boxes.add(input);
        }

        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();

        boxes.swap(firstIndex, secondIndex);
        System.out.println(boxes);
    }
}
