package ADVANCED.LAB05_MULTIDIMENSIONAL_ARRAYS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class L02_PositionsOf_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i++) {
                int number = Integer.parseInt(tokens[i]);
                matrix[row][i] = number;
            }
        }

        int number = Integer.parseInt(scanner.nextLine());

        ArrayList<int[]> positions = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    int[] indexes = new int[]{row, col};
                    positions.add(indexes);
                }
            }
        }

        if (positions.isEmpty()) {
            System.out.println("not found");
        } else {
            for (int[] position : positions) {
                System.out.println(position[0] + " " + position[1]);
            }

        }
    }


    private static int[] readArray(Scanner scanner) {
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        return arr;
    }
}
