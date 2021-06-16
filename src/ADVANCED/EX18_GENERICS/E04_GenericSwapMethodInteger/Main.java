package ADVANCED.EX18_GENERICS.E04_GenericSwapMethodInteger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Box> elements = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int line = Integer.parseInt(scanner.nextLine());
            Box<Integer> box = new Box<>(line);
            elements.add(box);
        }

        int[] tokens = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int firstIndex = tokens[0];
        int secondIndex = tokens[1];

        Box currentElement = elements.get(firstIndex);
        elements.set(firstIndex, elements.get(secondIndex));
        elements.set(secondIndex, currentElement);

        for (Box element : elements) {
            System.out.println(element);
        }

    }
}
