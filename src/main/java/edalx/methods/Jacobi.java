/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

import java.util.Arrays;

/**
 *
 * @author Alexander
 */
public class Jacobi {

    public static final int MAX_ITERATIONS = 100;
    private double[][] M;

    public Jacobi(double[][] matrix) {
        M = matrix;
    }

    public void print() {
        int n = M.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(M[i][j] + "\t");
            }
            System.out.print("|\t" + M[i][n] + "\t");
            System.out.println();
        }
    }

    public boolean transformToDominant(int r, boolean[] V, int[] R) {
        int n = M.length;
        if (r == M.length) {
            double[][] T = new double[n][n + 1];
            for (int i = 0; i < R.length; i++) {
                for (int j = 0; j < n + 1; j++) {
                    T[i][j] = M[R[i]][j];
                }
            }
            M = T;
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (V[i]) {
                continue;
            }
            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(M[i][j]);
            }
            if (2 * Math.abs(M[i][r]) > sum) { // diagonally dominant?
                V[i] = true;
                R[r] = i;
                if (transformToDominant(r + 1, V, R)) {
                    return true;
                }
                V[i] = false;
            }
        }
        return false;
    }

    /**
     * Una matriz es diagonal estrictamente dominante, cuando lo es por filas o
     * por columnas. Lo es por filas cuando, para todas las filas, el valor
     * absoluto del elemento de la diagonal de esa fila es estrictamente mayor
     * que la norma del resto de elementos de esa fila
     */
    public boolean makeDominant() {
        boolean[] visited = new boolean[M.length];
        int[] rows = new int[M.length];
        Arrays.fill(visited, false);

        return transformToDominant(0, visited, rows);
    }

    /**
     * Applies Jacobi method to find the solution of the system of linear
     * equations represented in matrix M. M is a matrix with the following form:
     * a_11 * x_1 + a_12 * x_2 + ... + a_1n * x_n = b_1 a_21 * x_1 + a_22 * x_2
     * + ... + a_2n * x_n = b_2 . . . . . . . . . . . . a_n1 * x_n + a_n2 * x_2
     * + ... + a_nn * x_n = b_n
     */
    public void solve(double tol, double[] P) {
        int iterations = 1;
        int n = M.length;
        double[] X = new double[n];
        System.out.print("X_0" + " = {");
        for (int i = 0; i < n; i++) {
            System.out.print(P[i] + " ");
        }
        System.out.println("}");
        while (true) {

            for (int i = 0; i < n; i++) {
                double sum = M[i][n]; // b_n

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= M[i][j] * P[j];
                    }
                }
                X[i] = 1 / M[i][i] * sum;
            }

            System.out.print("X_" + iterations + " = {");
            for (int i = 0; i < n; i++) {
                System.out.print(X[i] + " ");
            }
            System.out.println("}");

            iterations++;
            if (iterations == 1) {
                continue;
            }

            boolean stop = true;
            for (int i = 0; i < n && stop; i++) {
                if (Math.abs(X[i] - P[i]) > tol) {
                    stop = false;
                }
            }

            if (stop || iterations == MAX_ITERATIONS) {
                break;
            }
            P = (double[]) X.clone();
        }
    }

    public static void main(String[] args) {
        /* double[][] M = {{10.0, 2, 1, 7},
        {1, 5, 1, -8},
        {2, 3, 10, 6}};
        double[] X = {0.7, -1.6, 0.6};*/
        double[][] M = {{10, 1, 11},
        {2, 10, 12}};
        double[] X = {0.5, 0.5};
        double tol = 0.01;

        Jacobi jacobi = new Jacobi(M);

        if (!jacobi.makeDominant()) {
            System.out.println("El método es convergente o faltan iteraciones");
        }

        System.out.println("Matriz A");
        jacobi.print();
        System.out.println("");
        jacobi.solve(tol, X);

    }
}
