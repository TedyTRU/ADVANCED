package ADVANCED.EX18_GENERICS.E06_GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            box.addElement(num);
        }

        double value = Double.parseDouble(scanner.nextLine());

        long count = box.countGreaterValues(value);
        System.out.println(count);

    }
}
