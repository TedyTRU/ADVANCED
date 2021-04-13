package ADVANCED.LAB05_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class L03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        //Character[][] firstMatrix = new Character[rows][cols];
        //Character[] characters = Arrays.stream(scanner.nextLine().split("\\s+"))
        //                    .map(e -> e.charAt(0))
        //                    .toArray(Character[]::new);
        //firstMatrix[row] = characters;

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            firstMatrix[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
        }
        for (int row = 0; row < rows; row++) {
            secondMatrix[row] = scanner.nextLine().replaceAll("\\s+", "")
                    .toCharArray();
        }

        char[][] finalMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

//                if (firstMatrix[row][col] == secondMatrix[row][col]) {
//                    finalMatrix[row][col] = secondMatrix[row][col];
//
//                } else {
//                    finalMatrix[row][col] = '*';
//                }

                char firstSymbol = firstMatrix[row][col];
                char secondSymbol = secondMatrix[row][col];
                finalMatrix[row][col] = firstSymbol == secondSymbol ? firstSymbol : '*';

            }
        }

        printMatrix(finalMatrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            char[] arr = matrix[row];
            for (int col = 0; col < arr.length; col++) {
                System.out.print(arr[col] + " ");
            }
            System.out.println();
        }
    }
}

