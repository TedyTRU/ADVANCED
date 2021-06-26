package ADVANCED.EXAMS.EXAM_9;

import java.util.Scanner;

public class E02 {

    private static int row;
    private static int col;
    private static int length = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] screen = fillMatrix(scanner, n);

        boolean killedByEnemy = false;

        int food = foodCount(screen);

        for (String command : commands) {
            switch (command) {
                case "up":
                    row--;
                    validRows(screen, row);
                    break;
                case "down":
                    row++;
                    validRows(screen, row);
                    break;
                case "left":
                    col--;
                    validCol(screen, col);
                    break;
                case "right":
                    col++;
                    validCol(screen, col);
                    break;
            }

            if (screen[row][col] == 'f') {
                screen[row][col] = '*';
                length++;
                food--;
                if (food <= 0) {
                    break;
                }

            } else if (screen[row][col] == 'e') {
                System.out.println("You lose! Killed by an enemy!");
                killedByEnemy = true;
                break;
            }

        }

        food = foodCount(screen);

        if (food <= 0 && !killedByEnemy) {
            System.out.printf("You win! Final python length is %d", length);

        } else if (food > 0 && !killedByEnemy) {
            System.out.printf("You lose! There is still %d food to be eaten.", food);

        }

    }

    private static int foodCount(char[][] matrix) {
        int count = 0;
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                if (aChar == 'f') {
                    count++;
                }
            }
        }
        return count;
    }

    private static void validCol(char[][] matrix, int n) {
        if (n >= matrix.length) {
            col = 0;
        } else if (n < 0) {
            col = matrix.length - 1;
        }
    }

    private static void validRows(char[][] matrix, int n) {
        if (n >= matrix.length) {
            row = 0;
        } else if (n < 0) {
            row = matrix.length - 1;
        }
    }

    private static char[][] fillMatrix(Scanner scanner, int n) {
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine()
                    .replaceAll("\\s+", "");
            matrix[i] = input.toCharArray();
            if (input.contains("s")) {
                row = i;
                col = input.indexOf('s');
                matrix[row][col] = '*';
            }
        }
        return matrix;
    }
}
