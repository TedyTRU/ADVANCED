package ADVANCED.EXAMS.EXAM_2;

import java.util.Arrays;
import java.util.Scanner;

public class E02_BookWorm {

    public static int playerRow;
    public static int playerCol;
    public static StringBuilder letters = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder initialString = new StringBuilder(scanner.nextLine());

        char[][] matrix = fillMatrix(scanner);
        playerRow = playerPosition(matrix)[0];
        playerCol = playerPosition(matrix)[1];

        String command = scanner.nextLine();

        while (!"end".equals(command)) {

            switch (command) {
                case "up":
                    moveUp(matrix, playerRow, playerCol);
                    break;
                case "down":
                    moveDown(matrix, playerRow, playerCol);
                    break;
                case "left":
                    moveLeft(matrix, playerRow, playerCol);
                    break;
                case "right":
                    moveRight(matrix, playerRow, playerCol);
                    break;
            }

            command = scanner.nextLine();
        }

        System.out.println(initialString.append(letters));
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {

        Arrays.stream(matrix).forEach(e -> System.out.println(
                Arrays.toString(e)
                        .replaceAll("[\\[\\]]", "")
                        .replaceAll(", ", "")));
    }

    private static void moveRight(char[][] matrix, int row, int col) {
        col++;

        if (isValidIndex(row, col, matrix)) {
            if (matrix[row][col] != '-') {
                char symbol = matrix[row][col];
                letters.append(symbol);

            }
            matrix[row][--col] = '-';
            matrix[row][++col] = 'P';

        } else {
            if (!letters.toString().isEmpty()) {
                letters.deleteCharAt(letters.length() - 1);
            }
        }
        playerRow = row;
        playerCol = col;
    }

    private static void moveLeft(char[][] matrix, int row, int col) {
        col--;

        if (isValidIndex(row, col, matrix)) {
            if (matrix[row][col] != '-') {
                char symbol = matrix[row][col];
                letters.append(symbol);
                matrix[row][++col] = '-';
                matrix[row][--col] = 'P';

            } else {
                matrix[row][++col] = '-';
                matrix[row][--col] = 'P';
            }

        } else {
            if (!letters.toString().isEmpty()) {
                letters.deleteCharAt(letters.length() - 1);
            }
        }
        playerRow = row;
        playerCol = col;
    }

    private static void moveDown(char[][] matrix, int row, int col) {
        row++;

        if (isValidIndex(row, col, matrix)) {
            if (matrix[row][col] != '-') {
                char symbol = matrix[row][col];
                letters.append(symbol);

            }
            matrix[--row][col] = '-';
            matrix[++row][col] = 'P';

        } else {
            if (!letters.toString().isEmpty()) {
                letters.deleteCharAt(letters.length() - 1);
            }
        }
        playerRow = row;
        playerCol = col;
    }

    private static void moveUp(char[][] matrix, int row, int col) {
        row--;

        if (isValidIndex(row, col, matrix)) {
            if (matrix[row][col] != '-') {
                char symbol = matrix[row][col];
                letters.append(symbol);

            }
            matrix[++row][col] = '-';
            matrix[--row][col] = 'P';

        } else {
            if (!letters.toString().isEmpty()) {
                letters.deleteCharAt(letters.length() - 1);
            }
        }
        playerRow = row;
        playerCol = col;
    }

    private static boolean isValidIndex(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    private static int[] playerPosition(char[][] matrix) {
        int row = -1;
        int col = -1;

        boolean isFound = false;

        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols] == 'P') {
                    row = rows;
                    col = cols;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }
        int[] positions = new int[2];
        positions[0] = row;
        positions[1] = col;
        return positions;
    }

    private static char[][] fillMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        return matrix;
    }
}
