package com.example.edward.chordforme;

public class MatrixOpsLibrary {

    public MatrixOpsLibrary() {

    }

    public double[][] multiply(double[][] A, double[][] B) {

        int m = A.length;
        int p = B[0].length;

        if (A[0].length != B.length) {

            return null;

        } else {

            int n = A[0].length;
            double[][] C = new double[m][p];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < p; j++) {
                    double Cij = 0;
                    for (int k = 0; k < n; k++) {
                        Cij += (A[i][k] * B[k][j]);
                    }
                    C[i][j] = Cij;
                }
            }

            return C;

        }

    }

    private class elemRowOps {

        public elemRowOps() {

        }

        public double[][] swap(double[][] A, int row1, int row2) {

            double[][] B = A;
            double[] temp = B[row1];
            B[row1] = B[row2];
            B[row2] = temp;
            return B;

        }

        public double[][] scale(double[][] A, int row, int scale) {

            double[][] B = A;
            double[] newRow = new double[B[0].length];
            for (int i = 0; i < B[0].length; i++) {
                newRow[i] = B[row][i] * scale;
            }
            B[row] = newRow;
            return B;

        }

        public double[][] lincom(double[][] A, int destinationRow, int scaledRow, int scale) {

            double[][] B = A;
            double[] newRow = new double[B[0].length];
            for (int i = 0; i < B[0].length; i++) {
                newRow[i] = B[destinationRow][i] + B[scaledRow][i] * scale;
            }
            B[destinationRow] = newRow;
            return B;

        }

    }

}
