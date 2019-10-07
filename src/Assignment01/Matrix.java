package Assignment01;

import java.util.Scanner;

public class Matrix {

    public int row;
    public int column;
    int[][] elementArray;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        elementArray = new int[row][column];
    }

    public void populateMatrix(Scanner scanner) {
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                System.out.print("Enter element at row: " + r + " column: " + c + ">>");
                elementArray[r][c] = scanner.nextInt();
                System.out.println();
            }
        }
    }

    public String toString() {
        String matrixString = "";

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {

                if (column == 1) {
                    matrixString += "|" + elementArray[r][c] + "|";
                } else {

                    if (c == 0) {
                        matrixString += "|" + ("" + elementArray[r][c]);
                    } else if (c == column - 1) {
                        matrixString += elementArray[r][c] + "|";
                    } else {
                        matrixString += " " + elementArray[r][c] + " ";
                    }

                }

            }

            matrixString += "\n";
        }

        return matrixString;
    }

}
