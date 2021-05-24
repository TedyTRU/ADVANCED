package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotate = scanner.nextLine();
        int degrees = extractDegrees2(rotate);
        List<String> lines = new ArrayList<>();

        String line = scanner.nextLine();
        int cols = 0;

        while (!"END".equals(line)) {

            if (line.length() > cols) {
                cols = line.length();
            }

            lines.add(line);
            line = scanner.nextLine();
        }
        int rows = lines.size();

        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix, lines);

        if (degrees == 0) {
            printMatrix(matrix);

        } else if (degrees == 90) {
            char[][] newMatrix = rotateMatrix90(matrix);
            printMatrix(newMatrix);

        } else if (degrees == 180) {
            char[][] newMatrix = rotateMatrix180(matrix);
            printMatrix(newMatrix);

        } else if (degrees == 270) {
            char[][] newMatrix = rotateMatrix270(matrix);
            printMatrix(newMatrix);

        }

    }

    private static char[][] rotateMatrix270(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        char[][] rotatedMatrix = new char[col][row];

        col = matrix[0].length - 1;
        for (int i = 0; i < rotatedMatrix.length; i++) {
            for (int j = 0; j < rotatedMatrix[i].length; j++) {
                rotatedMatrix[i][j] = matrix[j][col];
            }
            col--;
        }
        return rotatedMatrix;
    }

    private static char[][] rotateMatrix180(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        char[][] rotatedMatrix = new char[row][col];

        for (int i = 0; i < rotatedMatrix.length; i++) {
            row--;
            col = matrix[0].length - 1;
            for (int j = 0; j < rotatedMatrix[i].length; j++) {
                rotatedMatrix[i][j] = matrix[row][col];
                col--;
            }
        }
        return rotatedMatrix;
    }

    private static char[][] rotateMatrix90(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        char[][] rotatedMatrix = new char[col][row];

        for (int i = 0; i < rotatedMatrix.length; i++) {
            row = matrix.length - 1;
            for (int j = 0; j < rotatedMatrix[i].length; j++) {
                rotatedMatrix[i][j] = matrix[row][i];
                row--;
            }
        }
        return rotatedMatrix;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, List<String> lines) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                if (col < lines.get(row).length()) {
                    matrix[row][col] = lines.get(row).charAt(col);

                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

    }

    private static int extractDegrees2(String rotate) {
        String regex = "([0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(rotate);
        int degrees = 0;
        if (matcher.find()) {
            degrees = Integer.parseInt(matcher.group(1));
        }
        while (degrees >= 360) {
            degrees = degrees % 360;
        }
        return degrees;
    }

    private static int extractDegrees(String rotate) {
        int firstIndex = rotate.indexOf('(');
        int finalIndex = rotate.indexOf(')');
        return Integer.parseInt(rotate.substring(firstIndex + 1, finalIndex));
    }
}
