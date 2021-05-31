package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class L04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> addVat = value -> value *= 1.2;

        double[] values = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble).toArray();

        System.out.println("Prices with VAT:");
        for (double value : values) {
            System.out.println(String.format("%.2f", addVat.apply(value)));
        }

    }
}
