package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class E02_MatrixOfPalindromes_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf).toArray();
        String[][] matrix = new String[dimensions[0]][dimensions[1]];

        fillMatrix(matrix);

        //printMatrix(matrix);
        Arrays.stream(matrix).forEach(arr -> {
            Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
            System.out.println();
        });

    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = String.format("%c%c%c",
                        97 + row, 97 + row + col, 97 + row);
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] row : matrix) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
