package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Scanner;

public class E01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix = new int[n][n];

        if ("A".equals(type)) {
            fillPatternA(matrix);
        } else if ("B".equals(type)) {
            fillPatternB(matrix);
        }

        printMatrix(matrix);

    }

    private static void fillPatternB(int[][] matrix) {

        int num = 1;
        for (int row = 0; row < matrix.length; row++) {

            if (row % 2 == 0) {
                for (int col = 0; col < matrix[row].length; col++) {
                    matrix[col][row] = num++;
                }
            } else {
                for (int col = matrix[row].length - 1; col >= 0; col--) {
                    matrix[col][row] = num++;
                }
            }
        }
    }

    private static void fillPatternA(int[][] matrix) {

        int num = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[col][row] = num++;
            }
        }
    }

    /**
     * random dox
     *
     * @param matrix принтиране на мартица
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }

}
