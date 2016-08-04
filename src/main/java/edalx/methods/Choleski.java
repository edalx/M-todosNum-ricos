/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

import edalx.models.defLU;
import java.util.Arrays;

/**
 *
 * @author edalx
 */
public class Choleski {

    public boolean isSymmetric(double[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i][j] != A[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSquare(double[][] A) {
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if (A[i].length != N) {
                return false;
            }
        }
        return true;
    }

    public defLU FactorizacionCholesky(double A[][], double[] b, int n) {
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];
        defLU result = new defLU();

        System.out.println("Factorización LU con el método Cholesky");
        System.out.println("Etapa 0");
        System.out.println("Matriz A");
        ImprimirMatriz(A, n);
        System.out.println("Matriz L");
        ImprimirMatriz(L, n);
        System.out.println("Matriz U");
        ImprimirMatriz(U, n);

        for (int k = 1; k < n + 1; k++) {
            System.out.println("Etapa #" + k);
            System.out.println("Hallar la Columna " + k + " de L y la Fila " + k + " de U");
            System.out.println("Matriz A");
            ImprimirMatriz(A, n);
            double Suma = 0;
            for (int p = 0; p < k - 1; p++) {
                Suma += L[k - 1][p] * U[p][k - 1];
            }
            if (A[k - 1][k - 1] - Suma > 0) {
                U[k - 1][k - 1] = Math.sqrt(A[k - 1][k - 1] - Suma);
                L[k - 1][k - 1] = U[k - 1][k - 1];
            } else {
                return null;
            }
            for (int j = k + 1; j < n + 1; j++) {
                Suma = 0;
                for (int p = 0; p < k - 1; p++) {

                    Suma += L[j - 1][p] * U[p][k - 1];
                }
                if (L[k - 1][k - 1] != 0) {
                    L[j - 1][k - 1] = (A[j - 1][k - 1] - Suma) / L[k - 1][k - 1];
                } else {
                    return null;
                }
            }

            System.out.println("Matriz L");
            ImprimirMatriz(L, n);
            for (int i = k + 1; i < n + 1; i++) {
                Suma = 0;
                for (int p = 0; p < k - 1; p++) {
                    Suma += L[k - 1][p] * U[p][i - 1];
                }
                if (L[k - 1][k - 1] != 0) {
                    U[k - 1][i - 1] = (A[k - 1][i - 1] - Suma) / L[k - 1][k - 1];
                } else {
                    return null;
                }
            }
            System.out.println("Matriz L(t)");
            ImprimirMatriz(U, n);
        }
        result.setL(L);
        result.setU(U);

        return result;

    }

    public double[] SustitucionProgresiva(double[][] L, double[] b) {
        int n = L.length;
        double z[] = new double[n];
        for (int i = 1; i < n + 1; ++i) {
            double Suma = 0;
            for (int p = i - 1; p > 0; --p) {
                double a = L[i - 2][p];
                double c = z[p - 1];
                Suma += (L[i - 1][p - 1] * z[p - 1]);
            }
            z[i - 1] = (b[i - 1] - Suma) / L[i - 1][i - 1];
        }
        return z;
    }

    public double[] SustitucionRegresiva(double[][] U, double[] z) {
        int n = U.length;
        double[] x = new double[n];
        for (int i = n - 1; i >= 0; --i) {
            double suma = 0;
            for (int j = i + 1; j < n; ++j) {
                suma += U[i][j] * x[j];
            }
            x[i] = (z[i] - suma) / U[i][i];
        }
        return x;
    }

    public static void ImprimirMatriz(double[][] matrix, int n) {
        for (int i = 0; i < n; ++i) {
            System.out.print("| ");
            for (int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j]);
                addSpace(String.valueOf(matrix[i][j]).length(), 20);
            }
            System.out.println(" |");
        }
        System.out.println("------------------------------------------------------------------------"
                + "-------------------------------------------");
    }

    public static void addSpace(int n, int k) {
        if (n < k) {
            for (int i = 0; i < k - n; ++i) {
                System.out.print(" ");
            }
        }
    }
}
