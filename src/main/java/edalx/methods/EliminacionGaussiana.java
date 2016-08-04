/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

import edalx.models.ModelPivoting;
import java.math.BigInteger;

/**
 *
 * @author edalx
 */
public class EliminacionGaussiana {

    public double[] gaussSinPivote(double[][] matriz, double[] coef) {
        double[] result = new double[coef.length];
        double[][] aumen = new double[coef.length][coef.length + 1];
        double[] x = new double[coef.length];
        for (int i = 0; i < coef.length; i++) {//LLenado de matriz aumentada
            for (int j = 0; j < coef.length + 1; j++) {
                if (j == coef.length) {
                    aumen[i][j] = coef[i];
                } else {
                    aumen[i][j] = matriz[i][j];
                }
            }
        }

        double aux = 0;
        System.out.println("");
        System.out.println("");
        System.out.println("Matriz ingresada:");
        printMatrizAumen(aumen);
        System.out.println("");
        System.out.println("");
        for (int k = 0; k < aumen.length - 1; k++) {
            for (int i = k + 1; i < aumen.length; i++) {
                if (aumen[k][k] == 0) {
                    System.out.println("Existen ceros en la diagonal superior");
                    printMatrizAumen(aumen);
                    return null;
                    // System.exit(0);
                }
                System.out.println("");
                System.out.println("");
                System.out.println("Se realizara la operacion F" + (k + 2) + "-F" + (k + 1) + "*" + aumen[i][k] + "/" + aumen[k][k]);
                aux = aumen[i][k] / aumen[k][k];
                aumen[i][k] = 0.0;
                for (int j = k + 1; j < coef.length + 1; j++) {
                    aumen[i][j] = aumen[i][j] - aux * aumen[k][j];
                }
                printMatrizAumen(aumen);
                System.out.println("");
                System.out.println("");

            }
            if (aumen[k + 1][k + 1] == 0) {
                System.out.println("Existen ceros en la diagonal superior");
                printMatrizAumen(aumen);
                return null;
                //System.exit(0);
            }

        }
        for (int i = 0; i < x.length; i++) {
            x[i] = aumen[i][coef.length];

        }

        for (int i = 0; i < result.length; i++) {
            result[i] = 0.0;
        }

        for (int i = aumen.length - 1; i >= 0; i--) {
            aux = 0;
            for (int j = i + 1; j < result.length; j++) {
                aux = aux + aumen[i][j] * result[j];
            }
            result[i] = (x[i] - aux) / aumen[i][i];
        }

        return result;

    }

    public void printMatrizAumen(double[][] aumen) {

        for (int i = 0; i < aumen.length; i++) {
            for (int j = 0; j < aumen.length + 1; j++) {
                System.out.print("\t" + aumen[i][j]);
            }
            System.out.println("");

        }
    }

    public double[] PartialPivoting(double[][] matriz, double[] coef) {
        int r = 0;
        double aux;
        double aux1;
        double m = 0;
        int n = coef.length;
        //Carga matriz aumentada
        double[] result = new double[coef.length];
        double[][] aumen = new double[n][n + 1];
        double[] x = new double[n];
        double redond = 0;
        double tol = 0.000000001;//Definición de toleranciañ
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (j == n) {
                    aumen[i][j] = coef[i];
                } else {
                    aumen[i][j] = matriz[i][j];
                }
            }
        }
//Operaciones y ceros

        for (int i = 0; i < coef.length - 1; i++) {
            r = i;
            for (int j = i + 1; j < coef.length; j++) { //Se busca el elemento mayor en la columna i
                if (Math.abs(aumen[j][i]) > Math.abs(aumen[r][i])) {
                    r = j;
                }
            }

            System.out.println("Numero mayor" + aumen[r][i]);

            if (aumen[r][i] == 0) {
                System.out.println("El sistema no tiene solucion unica");
            }

            System.out.println("Matriz original");
            printMatrizAumen(aumen);
            System.out.println("");
            System.out.println("");

            for (int k = 0; k < coef.length + 1; k++) {
                aux1 = aumen[i][k];
                aumen[i][k] = aumen[r][k];
                aumen[r][k] = aux1;
            }
            System.out.println("Cambio filas");
            printMatrizAumen(aumen);

            /////////////////////////////////////////     
            System.out.println("");
            System.out.println("");

            for (int k = i + 1; k < aumen.length; k++) {
                if (aumen[i][i] == 0) {
                    System.out.println("Existen ceros en la diagonal principal");
                    printMatrizAumen(aumen);
                    return null;
                    // System.exit(0);
                }
                System.out.println("");
                System.out.println("");
                System.out.println("Se realizara la operacion F" + (i + 2) + "-F" + (i + 1) + "*" + aumen[k][i] + "/" + aumen[i][i]);
                aux = aumen[k][i] / aumen[i][i];
                aumen[k][i] = 0.0;
                for (int j = i + 1; j < coef.length + 1; j++) {
                    redond = Math.abs(aumen[k][j] - aux * aumen[i][j]);
                    if (redond > tol) {
                        aumen[k][j] = aumen[k][j] - aux * aumen[i][j];
                    } else {//Se considera la tolerancia para asignar 0
                        aumen[k][j] = 0;
                    }
                }

            }
            if (aumen[i + 1][i + 1] == 0) {
                System.out.println("Existen ceros en la diagonal");
                printMatrizAumen(aumen);
                return null;
                //System.exit(0);
            }
        }
        printMatrizAumen(aumen);

        return result;
    }

   
    

    public ModelPivoting eliminacionGaussianaPivoteoTotal(int n, double[][] matriz) {
        System.out.println("ELIMINACIÓN GAUSSIANA CON PIVOTEO TOTAL");
        System.out.println("Matriz Original");
        int[] marcas = Marcas(n);
        ImprimirMatriz(matriz, n, marcas);
        ModelPivoting result = new ModelPivoting();
        for (int k = 1; k < n; ++k) {
            System.out.println("Etapa " + k);
            pivoteoTotal(matriz, marcas, k, n);
            System.out.println("Objetivo de la Etapa: Hacer ceros los elementos "
                    + "debajo del elemento A"
                    + k + "," + k + "= " + matriz[k - 1][k - 1]);
            System.out.println("\nMultiplicadores:");
            for (int i = k + 1; i < n + 1; ++i) {
                double multiplicador = matriz[i - 1][k - 1] / matriz[k - 1][k - 1];
                for (int j = k; j < n + 2; ++j) {
                    matriz[i - 1][j - 1] = matriz[i - 1][j - 1] - multiplicador * matriz[k - 1][j - 1];
                    if (i == j && matriz[i - 1][j - 1] == 0) {
                        System.out.println("");
                        System.out.println("Existen ceros en la diagonal principal elemento " + i + "," + j);
                        System.out.println("El sistema tiene infinitas soluciones");
                        ImprimirMatriz(matriz, n, marcas);
                        return null;
                    }
                }
                System.out.println("Multiplicador " + i + "," + k + " : " + multiplicador);
            }
            System.out.println(" ");
            ImprimirMatriz(matriz, n, marcas);
        }
        double x[] = new double[n];
        System.out.println("Resultado");
        for (int i = n; i > 0; --i) {
            double sumatoria = 0;
            for (int p = i + 1; p <= n; ++p) {
                sumatoria = sumatoria + matriz[i - 1][p - 1] * x[p - 1];
            }
            x[i - 1] = (matriz[i - 1][n] - sumatoria) / matriz[i - 1][i - 1];
            System.out.println("X" + marcas[i - 1] + " = " + x[i - 1]);
        }
        result.setMarcas(marcas);
        result.setResultado(x);
        return result;
    }

    public static int[] Marcas(int n) {
        int[] marcas = new int[n];
        for (int i = 0; i < n; ++i) {
            marcas[i] = i + 1;
        }
        return marcas;
    }

    public static double[][] pivoteoTotal(double[][] matriz, int[] marcas, int k, int n) {
        double mayor = 0;
        int FilaMayor = k - 1;
        int ColumnaMayor = k - 1;
        for (int y = k - 1; y < n; ++y) {
            for (int x = k - 1; x < n; ++x) {
                if (Math.abs(matriz[y][x]) > mayor) {
                    mayor = Math.abs(matriz[y][x]);
                    FilaMayor = y;
                    ColumnaMayor = x;
                }
            }
        }
        System.out.println("Elemento Mayor: " + mayor + " en la fila "
                + (FilaMayor + 1) + " y la columna " + (ColumnaMayor + 1));
        if (mayor == 0) {
            System.out.println("El sistema no tiene solución única.");
            System.exit(0);
        } else {
            if (FilaMayor != k - 1) {
                System.out.println("Cambio de fila " + k + " con fila "
                        + (FilaMayor + 1));
                for (int i = 0; i < matriz[0].length; i++) {
                    double aux = matriz[k - 1][i];
                    matriz[k - 1][i] = matriz[FilaMayor][i];
                    matriz[FilaMayor][i] = aux;
                }
                ImprimirMatriz(matriz, n, marcas);
            }
            if (ColumnaMayor != k - 1) {
                System.out.println("Cambio de columna " + k + " con la columna "
                        + (ColumnaMayor + 1));
                for (int i = 0; i < n; i++) {
                    double aux = matriz[i][k - 1];
                    matriz[i][k - 1] = matriz[i][ColumnaMayor];
                    matriz[i][ColumnaMayor] = aux;
                }
                int aux2 = marcas[ColumnaMayor];
                marcas[ColumnaMayor] = marcas[k - 1];
                marcas[k - 1] = aux2;
                ImprimirMatriz(matriz, n, marcas);
            }
        }
        return matriz;
    }

    public static void ImprimirMatriz(double[][] matrix, int n, int[] marcas) {
        for (int i = 0; i < n; i++) {
            System.out.print("X" + marcas[i]);
            addSpace(String.valueOf(marcas[i]).length(), 30);
        }
        System.out.print("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(matrix[i][j]);
                addSpace(String.valueOf(matrix[i][j]).length(), 30);
            }
            System.out.print("\n");
        }
        System.out.println("");
    }

    public static void addSpace(int n, int k) {
        if (n < k) {
            for (int i = 0; i < k - n; i++) {
                System.out.print(" ");
            }
        }
    }

}
