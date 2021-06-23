package ADVANCED.EXAMS.EXAM_4;

import java.util.Arrays;
import java.util.Scanner;

public class E02_Snake {

    private static int row;
    private static int col;
    private static int food = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = fillMatrix(scanner, n);
        setPosition(matrix, 'S');

        while (food < 10) {
            String command = scanner.nextLine();
            matrix[row][col] = '.';

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }

            if (isValidIndex(matrix, row, col)) {

                switch (matrix[row][col]) {
                    case '*':
                        food++;
                        matrix[row][col] = 'S';
                        break;
                    case 'B':
                        matrix[row][col] = '.';
                        setPosition(matrix, 'B');
                        break;
                }

            } else {
                break;
            }
        }

        if (!isValidIndex(matrix, row, col)) {
            System.out.println("Game over!");
        } else if (food >= 10) {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", food);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    private static void setPosition(char[][] matrix, char toFind) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == toFind) {
                    row = i;
                    col = j;
                }
            }
        }
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }
}
