package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS.E12;

import java.util.List;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int cols;
    private char[][] matrix;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new char[this.rows][this.cols];
    }

    public void setMatrix(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            this.matrix[i] = lines.get(i).toCharArray();
        }
    }

    public char getCell(int row, int col) {
        return this.matrix[row][col];
    }

    public void setCell(int row, int col, char fillColour) {
        this.matrix[row][col] = fillColour;
    }

    public boolean isOutOfBounds(int row, int col) {
        return row >= rows || row < 0 || col >= cols || col < 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(matrix[i][j]);
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}