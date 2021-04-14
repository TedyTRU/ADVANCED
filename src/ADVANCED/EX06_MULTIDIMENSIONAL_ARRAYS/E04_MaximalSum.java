package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class E04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(rows, cols, scanner);

        int maxSum = Integer.MIN_VALUE;
        int[] bestVector = new int[2];

        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[i].length - 2; j++) {

                int sum = findSum(i, j, matrix);
                if (sum > maxSum) {
                    maxSum = sum;
                    bestVector = new int[]{i, j};
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        printMatrix(matrix, bestVector);

    }

    private static void printMatrix(int[][] matrix, int[] bestVector) {
        for (int row = bestVector[0]; row < bestVector[0] + 3; row++) {
            for (int col = bestVector[1]; col < bestVector[1] + 3; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static int findSum(int i, int j, int[][] matrix) {
        int sum = 0;
        for (int row = i; row < 3 + i; row++) {
            for (int col = j; col < 3 + j; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] arr = readArray(scanner);
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = arr[col];
            }
        }
        return matrix;
    }
}
