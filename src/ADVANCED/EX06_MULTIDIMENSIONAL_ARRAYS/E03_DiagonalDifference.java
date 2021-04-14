package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class E03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);

        int sum = Math.abs(sumOfPrimaryDiagonal(matrix) - sumOfSecondaryDiagonal(matrix));

        System.out.println(sum);

    }

    private static int sumOfSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        int row = matrix.length - 1;

        for (int col = 0; col < matrix.length; col++) {
            sum += matrix[row--][col];
        }
        return sum;
    }

    private static int sumOfPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private static int[][] readMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = readArray(scanner);
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {

        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

}
