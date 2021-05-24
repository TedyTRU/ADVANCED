package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E07_Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimensions = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = fillMatrix(rows, cols);

        String line = reader.readLine();

        while (!"Nuke it from orbit".equals(line)) {
            String[] command = line.split("\\s+");
            int row = Integer.parseInt(command[0]);
            int col = Integer.parseInt(command[1]);
            int radius = Integer.parseInt(command[2]);

            destroyCells(matrix, row, col, radius);

            matrix.removeIf(List::isEmpty);
            line = reader.readLine();
        }

        printMap(matrix);

    }

    private static void printMap(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }

    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return (row >= 0 && row < matrix.size()
                && col >= 0 && col < matrix.get(row).size());

    }

    private static void destroyCells(List<List<Integer>> matrix, int row, int col, int radius) {

        for (int i = col + radius; i >= col - radius; i--) {
            if (isInRange(row, i, matrix)) {
                matrix.get(row).remove(i);
            }
        }

        for (int i = row - radius; i <= row + radius; i++) {
            if (isInRange(i, col, matrix) && i != row) {
                matrix.get(i).remove(col);
            }
        }
    }

    private static List<List<Integer>> fillMatrix(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < cols; j++, count++) {
                list.add(count);
            }
            matrix.add(i, list);
        }
        return matrix;
    }

}
