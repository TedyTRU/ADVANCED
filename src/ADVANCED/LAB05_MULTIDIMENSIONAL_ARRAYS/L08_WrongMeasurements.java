package ADVANCED.LAB05_MULTIDIMENSIONAL_ARRAYS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class L08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];
        for (int row = 0; row < n; row++) {
            matrix[row] = readArray(scanner);
        }

        int[] indexes = readArray(scanner);
        int wrongValue = matrix[indexes[0]][indexes[1]];

        ArrayList<int[]> fixedInfo = new ArrayList<>();

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongValue) {
                    int rightValue = calculateRightValue(matrix, row, col, wrongValue);
                    fixedInfo.add(new int[]{row, col, rightValue});
                }
            }
        }
        for (int[] info : fixedInfo) {
            matrix[info[0]][info[1]] = info[2];
        }
        printMatrix(matrix);
    }

    private static int calculateRightValue(int[][] matrix, int row, int col, int wrongValue) {
        int correctValue = 0;
        // up + down + left + right

        if (isBounds(matrix, row + 1, col) && matrix[row + 1][col] != wrongValue) {
            correctValue += matrix[row + 1][col];
        }
        if (isBounds(matrix, row - 1, col) && matrix[row - 1][col] != wrongValue) {
            correctValue += matrix[row - 1][col];
        }
        if (isBounds(matrix, row, col + 1) && matrix[row][col + 1] != wrongValue) {
            correctValue += matrix[row][col + 1];
        }
        if (isBounds(matrix, row, col - 1) && matrix[row][col - 1] != wrongValue) {
            correctValue += matrix[row][col - 1];
        }

        return correctValue;
    }

    private static boolean isBounds(int[][] matrix, int row, int col) {
        return row < matrix.length && row >= 0
                && col < matrix[row].length && col >= 0;
    }

    private static boolean isOutOfBounds(int[][] matrix, int row, int col) {
        return !isBounds(matrix, row, col);
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

}
