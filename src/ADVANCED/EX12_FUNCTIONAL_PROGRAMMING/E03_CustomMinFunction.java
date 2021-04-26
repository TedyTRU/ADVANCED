package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.function.Function;

public class E03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //int min = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).min().getAsInt();
        //System.out.println(min);


        // Function<Type, Return>
        Function<int[], Integer> getMinElement =
                number -> Arrays.stream(number).min().getAsInt();
        // public static int getMinElement(int[] numbers) {
        // return Arrays.stream(numbers).min().getAsInt();
        // }

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int minElement = getMinElement.apply(numbers);
        System.out.println(minElement);

    }
}
