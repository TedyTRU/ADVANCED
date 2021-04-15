package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class E05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = readArray(scanner);
        String[][] matrix = readMatrix(input, scanner);

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] data = line.split("\\s+");
            String command = data[0];

            if ("swap".equals(command) && data.length == 5) {
                int row1 = Integer.parseInt(data[1]);
                int col1 = Integer.parseInt(data[2]);
                int row2 = Integer.parseInt(data[3]);
                int col2 = Integer.parseInt(data[4]);

                if (validCoordinates(row1, row2, col1, col2, matrix)) {
                    swapElements(row1, row2, col1, col2, matrix);
                    printMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }

            line = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (String[] ints : matrix) {
            for (String anInt : ints) {
                System.out.printf("%s ", anInt);
            }
            System.out.println();
        }
    }

    private static void swapElements(int row1, int row2, int col1, int col2, String[][] matrix) {

        String element = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = element;

    }

    private static boolean validCoordinates(int row1, int row2, int col1, int col2, String[][] matrix) {

        return row1 >= 0 && row1 < matrix.length && row2 >= 0 && row2 < matrix.length
                && col1 >= 0 && col1 < matrix[row1].length && col2 >= 0 && col2 < matrix[row2].length;
    }

    private static String[][] readMatrix(int[] arr, Scanner scanner) {
        int rows = arr[0];
        int cols = arr[1];
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }

}
