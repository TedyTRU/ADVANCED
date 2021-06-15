package ADVANCED.EXAMS.EXAM_3;

import java.util.Arrays;
import java.util.Scanner;

public class E02_ReVolt {

    private static int row;
    private static int col;
    private static boolean hasWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());

        char[][] matrix = fillMatrix(scanner, n);
        row = playerPosition(matrix)[0];
        col = playerPosition(matrix)[1];

        while (m-- > 0) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveUp(matrix);
                    break;
                case "down":
                    moveDown(matrix);
                    break;
                case "left":
                    moveLeft(matrix);
                    break;
                case "right":
                    moveRight(matrix);
                    break;
            }

            if (hasWon) {
                break;
            }
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).forEach(e -> System.out.println(
                Arrays.toString(e)
                        .replaceAll("[\\[\\]]", "")
                        .replaceAll(", ", "")
        ));

    }

    private static void moveLeft(char[][] matrix) {
        int currentCol = col;
        col--;

        if (col == -1) {
            col = matrix[row].length - 1;
        }

        if (isValidIndex(matrix, row, col)) {
            switch (matrix[row][col]) {
                case 'B':
                    moveLeft(matrix);
                    break;
                case 'T':
                    col = currentCol;
                    break;
                case '-':
                    matrix[row][col] = 'f';
                    break;
                case 'F':
                    hasWon = true;
                    matrix[row][col] = 'f';
                    break;
            }

            if (matrix[row][currentCol] == 'f') {
                matrix[row][currentCol] = '-';
            }
        }
    }

    private static void moveRight(char[][] matrix) {
        int currentCol = col;
        col++;

        if (col == matrix[row].length) {
            col = 0;
        }

        if (isValidIndex(matrix, row, col)) {
            switch (matrix[row][col]) {
                case 'B':
                    moveRight(matrix);
                    break;
                case 'T':
                    col = currentCol;
                    break;
                case '-':
                    matrix[row][col] = 'f';
                    break;
                case 'F':
                    hasWon = true;
                    matrix[row][col] = 'f';
                    break;
            }

            if (matrix[row][currentCol] == 'f') {
                matrix[row][currentCol] = '-';
            }
        }
    }

    private static void moveDown(char[][] matrix) {
        int currentRow = row;
        row++;

        if (row == matrix.length) {
            row = 0;
        }

        if (isValidIndex(matrix, row, col)) {
            switch (matrix[row][col]) {
                case 'B':
                    moveDown(matrix);
                    break;
                case 'T':
                    row = currentRow;
                    break;
                case '-':
                    matrix[row][col] = 'f';
                    break;
                case 'F':
                    hasWon = true;
                    matrix[row][col] = 'f';
                    break;
            }

            if (matrix[currentRow][col] == 'f') {
                matrix[currentRow][col] = '-';
            }
        }
    }

    private static void moveUp(char[][] matrix) {
        int currentRow = row;
        row--;

        if (row == -1) {
            row = matrix.length - 1;
        }

        if (isValidIndex(matrix, row, col)) {
            switch (matrix[row][col]) {
                case 'B':
                    moveUp(matrix);
                    break;
                case 'T':
                    row = currentRow;
                    break;
                case '-':
                    matrix[row][col] = 'f';
                    break;
                case 'F':
                    hasWon = true;
                    matrix[row][col] = 'f';
                    break;
            }

            if (matrix[currentRow][col] == 'f') {
                matrix[currentRow][col] = '-';
            }
        }
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length &&
                col >= 0 && col < matrix[row].length;

    }

    private static int[] playerPosition(char[][] matrix) {
        int[] coordinates = new int[2];
        boolean isFound = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'f') {
                    coordinates[0] = i;
                    coordinates[1] = j;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        return coordinates;
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        return matrix;
    }
}
