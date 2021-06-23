package ADVANCED.EXAMS.EXAM_5;

import java.util.Arrays;
import java.util.Scanner;

public class E02_Bee {

    private static int row;
    private static int col;
    private static int flowers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = fillMatrix(scanner);
        setPosition(matrix, 'B');
        String command = scanner.nextLine();

        while (!command.equals("End")) {
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
                    case 'f':
                        flowers++;
                        break;
                    case 'O':
                        continue;
                }

                matrix[row][col] = 'B';

            } else {
                break;
            }

            command = scanner.nextLine();
        }

        if (!isValidIndex(matrix, row, col)) {
            System.out.println("The bee got lost!");
        }
        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - flowers));
        }
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).map(r -> Arrays.toString(r)
                .replaceAll("[\\[\\]]", "")
                .replaceAll(", ", ""))
                .forEach(System.out::println);
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
                    break;
                }
            }
        }
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
