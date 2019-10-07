package Assignment01;

import java.util.Scanner;

public class Main {

    private static Matrix matrixA, matrixB;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        System.out.println("Welcome to Matrix Calculator!");

        addElements();

        printInfo();

        while (true) {
            System.out.println("**********----------**********");
            System.out.print(">>");

            int command = scanner.nextInt();
            int option;
            Matrix result;
            switch (command) {
                case 1:
                    result = addMatrix(matrixA, matrixB);
                    if (result != null) {
                        System.out.println("MatrixA + MatrixB = \n" + result.toString());
                    } else {
                        System.out.println("The orders of matrices are not same. Hence, they can't be added.");
                    }
                    break;
                case 2:
                    System.out.println("Press 1 for MatrixA - MatrixB");
                    System.out.println("Press 2 for MatrixB - MatrixA");
                    System.out.print(">>");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            result = subtractMatrix(matrixA, matrixB);
                            if (result != null) {
                                System.out.println("MatrixA - MatrixB = \n" + result.toString());
                            } else {
                                System.out.println("The orders of matrices are not same. Hence, they can't be subtracted.");
                            }
                            break;
                        case 2:
                            result = subtractMatrix(matrixB, matrixA);
                            if (result != null) {
                                System.out.println("MatrixB - MatrixA = \n" + result.toString());
                            } else {
                                System.out.println("The orders of matrices are not same. Hence, they can't be subtracted.");
                            }
                            break;
                        default:
                            System.out.println("Wrong command.");
                            printInfo();
                            break;
                    }

                    break;
                case 3:
                    System.out.println("Press 1 for MatrixA * MatrixB");
                    System.out.println("Press 2 for MatrixB * MatrixA");
                    System.out.print(">>");
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            result = multiplyMatrix(matrixA, matrixB);
                            if(result != null) {
                                System.out.println("MatrixA * MatrixB = \n" + result.toString());
                            }
                            break;
                        case 2:
                            result = multiplyMatrix(matrixB, matrixA);
                            if(result != null){
                                System.out.println("MatrixB * MatrixA = \n" + result.toString());
                            }
                            break;
                        default:
                            System.out.println("Wrong command.");
                            break;
                    }
                    break;
                case 4:
                    addElements();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Wrong command");
                    break;
            }
        }

    }

    private static void printInfo() {
        System.out.println("Enter the appropriate number to commit an operation");
        System.out.println("Press 1 for add two matrices.");
        System.out.println("Press 2 for subtract two matrices.");
        System.out.println("Press 3 for multiply two matrices.");
        System.out.println("Press 4 for repopulate two matrices.");
        System.out.println("Press 5 to quit");
    }

    private static void addElements() {
        System.out.println("Insert the row number of Matrix A: ");
        System.out.print(">>");
        int rowA = scanner.nextInt();
        System.out.println("Insert the column number of Matrix A: ");
        System.out.print(">>");
        int columnA = scanner.nextInt();

        matrixA = new Matrix(rowA, columnA);

        System.out.println("Input the elements of Matrix A:");
        matrixA.populateMatrix(scanner);

        System.out.println("Now, Insert the row number of Matrix B: ");
        System.out.print(">>");
        int rowB = scanner.nextInt();
        System.out.println("Insert the column number of Matrix B: ");
        System.out.print(">>");
        int columnB = scanner.nextInt();

        matrixB = new Matrix(rowB, columnB);

        System.out.println("Input the elements of Matrix B:");
        matrixB.populateMatrix(scanner);

        System.out.println("MatrixA = \n" + matrixA.toString());
        System.out.println("MatrixB = \n" + matrixB.toString());
    }

    private static Matrix addMatrix(Matrix matrixA, Matrix matrixB) {
        Matrix result = null;

        if ((matrixA.row == matrixB.row) && (matrixA.column == matrixB.column)) {
            result = new Matrix(matrixA.row, matrixA.column);

            for (int r = 0; r < result.row; r++) {
                for (int c = 0; c < result.column; c++) {
                    result.elementArray[r][c] = matrixA.elementArray[r][c] + matrixB.elementArray[r][c];
                }
            }
        }

        return result;
    }

    private static Matrix subtractMatrix(Matrix matrixA, Matrix matrixB) {
        Matrix result = null;

        if ((matrixA.row == matrixB.row) && (matrixA.column == matrixB.column)) {
            result = new Matrix(matrixA.row, matrixA.column);

            for (int r = 0; r < result.row; r++) {
                for (int c = 0; c < result.column; c++) {
                    result.elementArray[r][c] = matrixA.elementArray[r][c] - matrixB.elementArray[r][c];
                }
            }
        }

        return result;
    }

    private static Matrix multiplyMatrix(Matrix matrixA, Matrix matrixB) {
        Matrix result = null;

        if (matrixA.column == matrixB.row) {
            result = new Matrix(matrixA.row, matrixB.column);
            for (int r = 0; r < result.row; r++) {
                for (int c = 0; c < result.column; c++) {
                    for (int i = 0; i < matrixA.column; i++) {
                        result.elementArray[r][c] += matrixA.elementArray[r][i] * matrixB.elementArray[i][c];
                    }
                }
            }
        } else {
            System.out.println("Orders of matrices are not correct.");
        }

        return result;
    }
}
