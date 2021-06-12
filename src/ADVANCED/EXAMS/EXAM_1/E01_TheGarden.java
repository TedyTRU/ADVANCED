package ADVANCED.EXAMS.EXAM_1;

import java.util.Arrays;
import java.util.Scanner;

public class E01_TheGarden {

    public static int carrots = 0;
    public static int potatoes = 0;
    public static int lettuce = 0;
    public static int harmedVegetables = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = fillTheMatrix(scanner);

        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("End")) {

            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);

            switch (command[0]) {

                case "Harvest":
                    if (checkIndexes(row, col, matrix)) {
                        doHarvest(row, col, matrix);
                    }
                    break;

                case "Mole":
                    if (checkIndexes(row, col, matrix)) {
                        doMole(matrix, command[3], row, col);
                    }
                    break;
            }

            command = scanner.nextLine().split("\\s+");
        }

        printMatrix(matrix);
        System.out.printf("Carrots: %d%n", carrots);
        System.out.printf("Potatoes: %d%n", potatoes);
        System.out.printf("Lettuce: %d%n", lettuce);
        System.out.printf("Harmed vegetables: %d%n", harmedVegetables);

    }

    private static void printMatrix(char[][] matrix) {
//        for (int rows = 0; rows < matrix.length; rows++) {
//            for (int cols = 0; cols < matrix[rows].length; cols++) {
//                System.out.print(matrix[rows][cols] + " ");
//            }
//            System.out.println();
//        }

        Arrays.stream(matrix).forEach(e -> System.out.println(Arrays.toString(e)
                .replaceAll("[\\[\\]]", "").replaceAll(", ", " ")));

    }

    private static void doMole(char[][] matrix, String direction1, int row, int col) {
        String direction = direction1.toLowerCase();

        switch (direction) {
            case "up":
                moleUp(row, col, matrix);
                break;
            case "down":
                moleDown(row, col, matrix);
                break;
            case "left":
                moleLeft(row, col, matrix);
                break;
            case "right":
                moleRight(row, col, matrix);
                break;
        }
    }

    private static void moleLeft(int row, int col, char[][] matrix) {

        for (int i = col; i >= 0; i -= 2) {
            if (matrix[row][i] != ' ') {
                matrix[row][i] = ' ';
                harmedVegetables++;
            }

        }

    }

    private static void moleRight(int row, int col, char[][] matrix) {

        for (int i = col; i < matrix[row].length; i += 2) {
            if (matrix[row][i] != ' ') {
                matrix[row][i] = ' ';
                harmedVegetables++;
            }
        }

    }

    private static void moleDown(int row, int col, char[][] matrix) {

        for (int i = row; i < matrix.length; i += 2) {
            if (matrix[i][col] != ' ') {
                matrix[i][col] = ' ';
                harmedVegetables++;
            }
        }

    }

    private static void moleUp(int row, int col, char[][] matrix) {

        for (int i = row; i >= 0; i -= 2) {
            if (matrix[i][col] != ' ') {
                matrix[i][col] = ' ';
                harmedVegetables++;
            }
        }

    }

    private static void doHarvest(int row, int col, char[][] matrix) {
        char vegetable = matrix[row][col];
        switch (vegetable) {
            case 'C':
                carrots++;
                break;
            case 'P':
                potatoes++;
                break;
            case 'L':
                lettuce++;
                break;
        }
        matrix[row][col] = ' ';
    }

    private static boolean checkIndexes(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix[row].length;
    }

    private static char[][] fillTheMatrix(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = scanner.nextLine()
                    .replaceAll("\\s+", "")
                    .toCharArray();
        }
        return matrix;
    }
}
