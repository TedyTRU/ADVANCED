package ADVANCED.EX06_MULTIDIMENSIONAL_ARRAYS.E12;

public class Bucket {

    private int row;
    private int col;
    private char colourToReplace;
    //private char fillColour;
    private Matrix matrix;

    public Bucket(int row, int col, Matrix matrix) {
        this.row = row;
        this.col = col;
        this.colourToReplace = matrix.getCell(row, col);
        this.matrix = matrix;
    }

    public void paint(char fillColour) {
        // DFS

        paint(row, col, colourToReplace, fillColour, matrix);
    }

    public void paint(int row, int col, char colourToReplace, char fillColour, Matrix matrix) {

        if (matrix.isOutOfBounds(row, col)
                || matrix.getCell(row, col) != colourToReplace
                || matrix.getCell(row, col) == fillColour)  {
            return;
        }

        matrix.setCell(row, col, fillColour);

        // up
        paint(row - 1, col, colourToReplace, fillColour, matrix);
        // down
        paint(row + 1, col, colourToReplace, fillColour, matrix);
        // left
        paint(row, col - 1, colourToReplace, fillColour, matrix);
        //right
        paint(row, col + 1, colourToReplace, fillColour, matrix);

    }

}
