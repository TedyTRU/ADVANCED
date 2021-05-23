package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        fillMatrix(matrix, scanner);

        int sumFirstDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int i = 0; i < size; i++) {
            sumFirstDiagonal += matrix[i][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            sumSecondDiagonal += matrix[--size][i];
        }

        System.out.println(Math.abs(sumFirstDiagonal - sumSecondDiagonal));
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int rows = 0; rows < matrix.length; rows++) {
            matrix[rows] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::valueOf).toArray();
        }
    }

}
