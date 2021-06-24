package ADVANCED.EXAMS.EXAM_6;

import java.util.Arrays;
import java.util.Scanner;

public class E02_Selling {

    private static int row;
    private static int col;
    private static int collectedMoney = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = fillMatrix(scanner);
        findPosition(matrix, 'S');

        while (collectedMoney < 50) {
            String movement = scanner.nextLine();

            matrix[row][col] = '-';

            switch (movement) {
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

                if (Character.isDigit(matrix[row][col])) {
                    char symbol = matrix[row][col];
                    collectedMoney += Integer.parseInt(String.valueOf(symbol));

                } else if (matrix[row][col] == 'O') {
                    matrix[row][col] = '-';
                    findPosition(matrix, 'O');
                }

                matrix[row][col] = 'S';

            } else {
                break;
            }
        }

        if (!isValidIndex(matrix, row, col)) {
            System.out.println("Bad news, you are out of the bakery.");

        } else if (collectedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }

        System.out.printf("Money: %d%n", collectedMoney);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(r -> Arrays.toString(r)
                .replaceAll("[\\[\\]]", "")
                .replaceAll(", ", ""))
                .forEach(System.out::println);
    }

    private static void findPosition(char[][] matrix, char toFind) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == toFind) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
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
