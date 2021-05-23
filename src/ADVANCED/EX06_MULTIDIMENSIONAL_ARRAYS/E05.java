package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);

        String command = scanner.nextLine();
        while (!"END".equals(command)) {

            if (isValidCommand(command)) {
                int row1 = Integer.parseInt(command.split("\\s+")[1]);
                int row2 = Integer.parseInt(command.split("\\s+")[3]);
                int col1 = Integer.parseInt(command.split("\\s+")[2]);
                int col2 = Integer.parseInt(command.split("\\s+")[4]);

                if (hasValidCoordinates(matrix, row1, col1) &&
                        hasValidCoordinates(matrix, row2, col2)) {

                    swapElements(matrix, matrix[row1], row2, col1, col2);
                    printMatrix(matrix);

                } else {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }

    }

    private static void swapElements(String[][] matrix, String[] matrix1, int row2, int col1, int col2) {
        String element = matrix1[col1];
        matrix1[col1] = matrix[row2][col2];
        matrix[row2][col2] = element;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] array : matrix) {
            for (String element : array) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::valueOf).toArray();
    }

    private static String[][] readMatrix(Scanner scanner) {
        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }

    private static boolean isValidCommand(String command) {
        String[] tokens = command.split("\\s+");
        return tokens.length == 5 && tokens[0].equals("swap");
    }

    private static boolean hasValidCoordinates(String[][] matrix, int row, int col) {
        return (row >= 0 && row < matrix.length)
                && (col >= 0 && col < matrix[0].length);
    }

}
