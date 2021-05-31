package ADVANCED.LAB11_FUNCTIONAL_PROGRAMMING;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class L03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> isUpperLetter = word ->
                Character.isUpperCase(word.charAt(0));

        ArrayList<String> result = new ArrayList<>();

        for (String word : words) {
            if (isUpperLetter.test(word)) {
                result.add(word);
            }
        }

        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }

    }
}
