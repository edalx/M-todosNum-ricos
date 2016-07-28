/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

/**
 *
 * @author Alexander
 */
public class GaussSeidel {

    public double[] solve(double[][] M, double b[], double X[], int maxIterations, double tol) {
        int iterations = 1;
        int n = M.length;
        double sum;
        double P[];
        System.out.print("X_0" + " = {");
        for (int i = 0; i < n; i++) {
            System.out.print(X[i] + " ");
        }
        System.out.println("}");
        while (true) {
            P = (double[]) X.clone();
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum = sum + M[i][j] * X[j];
                    }
                }
                if (M[i][i] != 0) {
                    X[i] = (b[i] - sum) / M[i][i];
                } else {
                    return null;
                }
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

            if (stop || iterations == maxIterations) {
                break;
            }

        }
        return X;
    }

    public static void main(String[] args) {
        double[][] M = {{5, -2, 1},
                        {-1, -7, 3},
                        {2, -1, 8}
        };
        double[] b = {3, -2, 1};
        double[] X = {0, 0, 0};
        double tol = 0.000001;
        int maxIterations = 100;
        GaussSeidel method = new GaussSeidel();
        System.out.println("Matriz A");
        System.out.println("");
        method.solve(M, b, X, maxIterations, tol);

    }
}
