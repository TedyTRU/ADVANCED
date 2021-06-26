package ADVANCED.EXAMS.EXAM_7;

import java.util.Arrays;
import java.util.Scanner;

public class E02_Bomb {

    private static int row;
    private static int col;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] matrix = fillMatrix(scanner, n);
        boolean getEnd = false;

        for (String command : commands) {
            switch (command) {
                case "up":
                    if (row - 1 >= 0) {
                        row--;
                    }
                    break;
                case "down":
                    if (row + 1 < matrix.length) {
                        row++;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        col--;
                    }
                    break;
                case "right":
                    if (col + 1 < matrix[row].length) {
                        col++;
                    }
                    break;
            }

            if (matrix[row][col] == 'B') {
                System.out.println("You found a bomb!");
                matrix[row][col] = '+';

            } else if (matrix[row][col] == 'e') {
                getEnd = true;
                break;
            }
        }

        int count = countBombs(matrix);
        if (count == 0) {
            System.out.println("Congratulations! You found all bombs!");

        } else if (getEnd) {
            System.out.printf("END! %d bombs left on the field", count);

        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", count, row, col);

        }

    }

    private static int countBombs(char[][] matrix) {
        int count = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'B') {
                    count++;
                }
            }
        }
        return count;
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine().replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();
            if (input.contains("s")) {
                row = i;
                col = input.indexOf('s');
            }
        }
        return matrix;
    }
}