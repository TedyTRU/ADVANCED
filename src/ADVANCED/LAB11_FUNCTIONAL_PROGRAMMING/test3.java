package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.List;
import java.util.stream.Stream;

public class test3 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Get first number greater than 3, is odd and print it * 2


        // Lazy evaluation

        Stream<Integer> integerStream = numbers.stream()
                .filter(test3::isGreaterThanTree)
                .filter(test3::isEven)
                .map(test3::byTwo);

        System.out.println(integerStream);

        System.out.println(integerStream
        .findFirst());


//
        System.out.println(numbers.stream()
                .filter(test3::isGreaterThanTree)     // .filter(n -> n > 3)
                .filter(test3::isEven)              // .filter(n -> n % 2 == 0)
                .map(test3::byTwo)                 // .map(n -> n * 2)
                .findFirst()
                .get());


//        for (int i = 0; i < numbers.size(); i++) {
//            if (numbers.get(i) > 3 && numbers.get(i) % 2 != 0) {
//                System.out.println(numbers.get(i) * 2);
//                break;
//            }
//        }

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
