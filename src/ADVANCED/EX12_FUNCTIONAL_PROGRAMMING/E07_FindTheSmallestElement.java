package ADVANCED.EX12_FUNCTIONAL_PROGRAMMING;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class E07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfIntegers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> indexOfSmallestNumber = list ->
                list.lastIndexOf(list.stream().min(Integer::compare).get());

        int index = indexOfSmallestNumber.apply(listOfIntegers);
        System.out.println(index);

//        System.out.println(listOfIntegers.lastIndexOf(getMinElement(listOfIntegers)));

    }

//    public static int getMinElement(List<Integer> list) {
//        return list.stream().min(Integer::compare).get();
//    }

}
