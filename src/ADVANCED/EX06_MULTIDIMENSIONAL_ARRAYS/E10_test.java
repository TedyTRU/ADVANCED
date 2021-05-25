package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class E10_test {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[][] matrix = new char[3][4];



        char[][] matrix2 = reader.lines()
                .limit(Long.parseLong(reader.readLine().split("\\s+")[0]))  // брой линий, коит се четат
                .map(String::toCharArray)  // мапване
                .toArray(char[][]::new);   // събиране в контейнер и обработка




        // 1.
        Arrays.stream(matrix)
                .map(String::new)
                .collect(Collectors.joining(System.lineSeparator()));

        // 2.
        Arrays.stream(matrix)
                .map(String::new)
                .forEach(System.out::println);

        // 3.
        for (char[] chars : matrix) {
            System.out.println(new String(chars));
        }


    }
}
