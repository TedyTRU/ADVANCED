package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class E11_ReverseMatrixDiagonals_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = readMatrix(reader);
        int row = matrix.length - 1;
        int col = matrix[row].length - 1;

        while (col >= 0) {
            printDiagonals(col, row, matrix);
            if (col == 0) {
                row--;

                while (row >= 0) {
                    printDiagonals(col, row, matrix);
                    row--;
                }
            }
            col--;
        }

    }

    private static void printDiagonals(int col, int row, int[][] matrix) {
        int increaseCol = 0;
        for (int i = row; i >= 0; i--) {
            if (col + increaseCol < matrix[row].length) {
                System.out.printf("%d ", matrix[i][col + increaseCol]);
            } else {
                break;
            }
            increaseCol++;
        }
        System.out.println();
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        int[] dimensions = readArray(reader);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(reader);
        }
        return matrix;
    }

    private static int[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
