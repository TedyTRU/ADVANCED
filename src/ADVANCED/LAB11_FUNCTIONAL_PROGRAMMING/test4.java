package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class test4 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

//        int order = 1;
//        Consumer<Integer> printer = num -> System.out.println((order) + ". -> " + num);
//        numbers.parallelStream().forEach(e -> printer.accept(e));

        int[] order = {1};
        Consumer<Integer> printer = num -> System.out.println((order[0]++) + ". -> " + num);

        //numbers.parallelStream().forEach(printer::accept);

        numbers.stream().forEach(printer);

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
