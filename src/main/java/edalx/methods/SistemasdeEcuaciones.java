/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

import edalx.models.defLU;

/**
 *
 * @author edalx
 */
public class SistemasdeEcuaciones {

    public static defLU factorizacionLU(double[][] A) {
        int n = A.length;
        int l = A[0].length;
        defLU result = new defLU();
        if (n != l) {
            System.out.println("A no es una matriz cuadrada.");
        } else {
            double[][] L = new double[n][n];
            double[][] U = new double[n][n];

            double suma1, suma2, suma3;
            for (int k = 0; k < n; k++) {
                suma1 = 0;
                for (int p = 0; p < k; p++) {//Despues de la diagonal hacia abajo para lij
                    suma1 = suma1 + L[k][p] * U[p][k];
                }

                L[k][k] = A[k][k] - suma1;
                U[k][k] = 1;

                for (int i = k + 1; i < n; i++) {
                    suma2 = 0;
                    for (int r = 0; r < k; r++) {
                        suma2 = suma2 + L[i][r] * U[r][k];
                    }
                    L[i][k] = A[i][k] - suma2;
                }
                for (int j = k + 1; j < n; j++) {
                    suma3 = 0;
                    for (int s = 0; s < k; s++) {//Llenado de uij hasta antes de la diagonal
                        suma3 = suma3 + L[k][s] * U[s][j];
                    }
                    if (L[k][k] == 0) {
                        System.out.println("-------------------------------------------------------------------------");
                        System.out.println("    Matriz singular o no se puede factorar en la forma LU  ");
                        System.out.println("-------------------------------------------------------------------------");
                        return null;
                    }
                    U[k][j] = (A[k][j] - suma3) / L[k][k];

                }
            }
            System.out.println("Matriz L");
            printMatrix(L);
            System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------------------");
            System.out.println("Matriz U");
            printMatrix(U);
             System.out.println("");
            System.out.println("----------------------------------------------------------------------------------------------------");
            result.setL(L);
            result.setU(U);
        }

        return result;
    }

    public static void printMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                System.out.print("\t" + m[i][j]);
            }
            System.out.println("");
        }
    }

}
