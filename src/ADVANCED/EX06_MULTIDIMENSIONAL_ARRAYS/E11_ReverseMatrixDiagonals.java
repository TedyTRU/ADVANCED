package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class E11_ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = readMatrix(reader);

        Map<Integer, List<Integer>> diagonals = new HashMap<>();

        for (int i = 0, diagonal = 0, row = matrix.length - 1; row >= 0; row--, diagonal = ++i) {
            for (int col = matrix[row].length - 1; col >= 0 && col >= i; col--, diagonal++) {
                addValueToDiagonal(diagonals, matrix[row][col], diagonal);
            }

            for (int r = matrix.length - 1 - 1 - i; r >= 0 && i < matrix[row].length; r--, diagonal++) {
                addValueToDiagonal(diagonals, matrix[r][i], diagonal);
            }
        }

        diagonals.entrySet().forEach(e -> {
            for (Integer integer : e.getValue()) {
                System.out.print(integer + " ");
            }
            System.out.println();
        });

    }

    private static void addValueToDiagonal(Map<Integer, List<Integer>> diagonals, int value, int diagonal) {
        diagonals.putIfAbsent(diagonal, new ArrayList<>());
        diagonals.get(diagonal).add(value);
    }

    private static int[][] readMatrix(BufferedReader reader) throws IOException {
        int[] dimensions = readArray(reader);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = readArray(reader);
        }
        return matrix;
    }

    private static int[] readArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
