package ADVANCED.LAB05_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class L02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(scanner);
        int number = Integer.parseInt(scanner.nextLine());

        boolean isEqual = false;

        for (int row = 0; row < matrix.length; row++) {

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    System.out.println(row + " " + col);
                    isEqual = true;
                }
            }
        }

        if (!isEqual) {
            System.out.println("not found");
        }

    }

    private static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static int[][] readMatrix(Scanner scanner) {
        int[] rowsAndCols = readArray(scanner);
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(scanner);
        }

        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        return arr;
    }
}

