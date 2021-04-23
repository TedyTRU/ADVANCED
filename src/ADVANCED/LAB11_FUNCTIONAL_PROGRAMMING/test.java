package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.stream.IntStream;

public class test {
    public static void main(String[] args) {

        int[] numbers = {13, 42, 69, 73, 21};

        for (int number : numbers) {
            System.out.println(number + " " + isPrime(number));
        }

    }

    public static boolean isPrime(int number) {

        boolean isPrime =
                IntStream
                        .range(2, number)
                        .noneMatch(n -> number % n == 0);

        return isPrime && number > 1;
    }

}
