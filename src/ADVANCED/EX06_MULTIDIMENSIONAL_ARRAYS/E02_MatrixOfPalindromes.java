package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS;

import java.util.Scanner;

public class E02_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        char a = 'a';
        char b = 'a';

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(a);
                System.out.print(b);
                System.out.print(a);
                System.out.print(" ");
                b++;
            }
            System.out.println();
            a++;
            b = a;
        }
    }

}
