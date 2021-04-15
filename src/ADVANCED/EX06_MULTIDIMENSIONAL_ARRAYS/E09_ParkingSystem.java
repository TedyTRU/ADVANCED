package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Arrays;
import java.util.Scanner;

public class E09_ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = readArray(scanner.nextLine());
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
//        boolean[][] isOccupied = new boolean[rows][cols];
//        for (int i = 0; i < isOccupied.length; i++) {
//            isOccupied[i][0] = true;
//        }

        String line = scanner.nextLine();
        while (!"stop".equals(line)) {
            int[] parkingSpots = readArray(line);
            int Z = parkingSpots[0];
            int X = parkingSpots[1];
            int Y = parkingSpots[2];

            int distance = 1;
            distance += Math.abs(Z - X);
            boolean hasFoundPlace = false;

            if (matrix[X][Y] == 0) {
                distance += Y;
                matrix[X][Y] = 1;
                hasFoundPlace = true;

            } else {
                for (int i = 1; i < matrix[X].length; i++) {
                    if ((Y - i) > 0 && matrix[X][Y - i] == 0) {
                        distance += Y - i;
                        matrix[X][Y - i] = 1;
                        hasFoundPlace = true;
                        break;
                    }
                    if ((Y + i) < matrix[X].length && matrix[X][Y + i] == 0) {
                        distance += Y + i;
                        matrix[X][Y + i] = 1;
                        hasFoundPlace = true;
                        break;
                    }
                }
            }
            if (hasFoundPlace) {
                System.out.println(distance);
            } else {
                System.out.printf("Row %d full%n", X);
            }

            line = scanner.nextLine();
        }

    }

    private static int[] readArray(String string) {
        return Arrays.stream(string.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
