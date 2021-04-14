package ADVANCED.LAB05_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class L06_test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int row = 0, col = n - 1;
        while (row < n) {
            int innerRow = row;
            int innerCol = col;

            while (innerRow < n && innerCol < n) {
                System.out.print(matrix[innerRow++][innerCol++] + " ");
            }

            System.out.println();

            col--;
            if (col < 0) {
                col = 0;
                row++;
            }
        }
    }
}
