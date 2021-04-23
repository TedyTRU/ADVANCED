package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class test5 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        AtomicInteger order = new AtomicInteger(0);

        Consumer<Integer> printer = num -> System.out.println(order.incrementAndGet() + ". -> " + num);

        numbers.forEach(printer);

    }

    public static boolean isGreaterThanTree(int number) {
        System.out.println("isGreaterThanTree " + number);
        return number > 3;
    }

    public static boolean isEven(int number) {
        System.out.println("isEven " + number);
        return number % 2 == 0;
    }

    public static Integer byTwo(int number) {
        System.out.println("byTwo " + number);
        return number * 2;
    }

}
