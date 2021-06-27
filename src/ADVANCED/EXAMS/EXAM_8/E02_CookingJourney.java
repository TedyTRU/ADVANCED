package ADVANCED.EXAMS.EXAM_8;

import java.util.Arrays;
import java.util.Scanner;

public class E02_CookingJourney {

    private static int row;
    private static int col;
    private static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = fillMatrix(scanner);
        getPosition(matrix, 'S');

        while (money <= 50) {
            matrix[row][col] = '-';
            String command = scanner.nextLine();
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
            if (validPosition(matrix, row, col)) {
                if (Character.isDigit(matrix[row][col])) {
                    money += Integer.parseInt(String.valueOf(matrix[row][col]));
                    matrix[row][col] = 'S';

                } else if (matrix[row][col] == 'P') {
                    matrix[row][col] = '-';
                    getPosition(matrix, 'P');
                }

            } else {
                break;
            }

        }

        if (!validPosition(matrix, row, col)) {
            System.out.println("Bad news! You are out of the pastry shop.");

        } else if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");

        }

        System.out.printf("Money: %d%n", money);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(r -> Arrays.toString(r)
                .replaceAll("[\\[\\]]", "")
                .replaceAll(", ", ""))
                .forEach(System.out::println);
    }

    private static boolean validPosition(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    private static void getPosition(char[][] matrix, char toFInd) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == toFInd) {
                    row = i;
                    col = j;
                }
            }
        }
    }

    private static char[][] fillMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine()
                    .replaceAll("", "")
                    .toCharArray();
        }
        return matrix;
    }
}
