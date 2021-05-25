package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class E10_RadioactiveMutantVampireBunnies {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];
        ArrayDeque<Integer> queueOfPositions = new ArrayDeque<>();

        int[] playerIndexes = new int[2];

        for (int r = 0; r < rows; r++) {
            String[] currentRow = reader.readLine().split("");

            matrix[r] = currentRow;

            for (int c = 0; c < cols; c++) {
                if (matrix[r][c].equals("P")) {
                    playerIndexes[0] = r;
                    playerIndexes[1] = c;
                    matrix[r][c] = ".";

                } else if (matrix[r][c].equals("B")) {
                    queueOfPositions.offer(r);
                    queueOfPositions.offer(c);
                }
            }
        }

        String[] playerDirections = reader.readLine().split("");
        boolean isPlayerDead = false;
        int count = -1;

        while (playerDirections.length > count++ && !isPlayerDead) {
            String movement = playerDirections[count];

            moveBunnies(matrix, queueOfPositions);

            int playerRow = playerIndexes[0];
            int playerCol = playerIndexes[1];

            switch (movement) {
                case "U":
                    playerRow--;
                    break;
                case "D":
                    playerRow++;
                    break;
                case "L":
                    playerCol--;
                    break;
                case "R":
                    playerCol++;
                    break;
            }

            if (!isInBounds(playerRow, playerCol, matrix)) {
                break;
            }

            playerIndexes[0] = playerRow;
            playerIndexes[1] = playerCol;

            if (!isCellFree(playerRow, playerCol, matrix)) {
                isPlayerDead = true;
                break;
            }
        }

        printMatrix(matrix);

        if (isPlayerDead) {
            System.out.printf("dead: %d %d%n", playerIndexes[0], playerIndexes[1]);
        } else {
            System.out.printf("won: %d %d%n", playerIndexes[0], playerIndexes[1]);
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static void moveBunnies(String[][] matrix, ArrayDeque<Integer> queue) {
        int[] rowMovement = {1, -1, 0, 0};
        int[] colMovement = {0, 0, 1, -1};

        int lengthOperations = queue.size() / 2;

        for (int i = 0; i < lengthOperations; i++) {
            int row = queue.poll();
            int col = queue.poll();

            for (int j = 0; j < rowMovement.length; j++) {
                int newRow = row + rowMovement[j];
                int newCol = col + colMovement[j];

                if (!isInBounds(newRow, newCol, matrix)) {
                    continue;
                }
                if (matrix[newRow][newCol].equals("B")) {
                    continue;
                }

                matrix[newRow][newCol] = "B";
                queue.offer(newRow);
                queue.offer(newCol);

            }
        }
    }

    private static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isCellFree(int row, int col, String[][] matrix) {
        return matrix[row][col].equals(".");
    }

}
