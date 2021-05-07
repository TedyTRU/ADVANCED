package ADVANCED.EX20_ITERATORS_AND_COMPARATORS.E01_ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> data = Arrays.stream(sc.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(data);

        String line = sc.nextLine();

        while (!"END".equals(line)) {

            switch (line) {
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                        listyIterator.print();
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            line = sc.nextLine();
        }


    }
}
