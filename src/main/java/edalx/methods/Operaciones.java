/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

import java.util.StringTokenizer;

/**
 *
 * @author Alexander
 */
public class Operaciones {

    public String[] matrizTokens(String cadena, int filas) {
        int cont1 = 0;
        String[] matrizBorrador = new String[filas];
        StringTokenizer st = new StringTokenizer(cadena, "\n");
        while (st.hasMoreTokens()) {
            matrizBorrador[cont1] = st.nextToken();
            cont1++;
        }
        return matrizBorrador;

    }

    /**
     * Captura la matriz en un arreglo bidimensional
     *
     * @param matriz1 matriz de tokens
     * @param columnas dimension de la nueva matriz
     * @param filas dimension de la nueva matriz
     * @return El método devuelve una matriz de tokens convertidos a numeros
     */
    public double[][] capturaMatriz(String[] matriz1, int filas, int columnas) {
        double[][] matrizOriginal = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            StringTokenizer st1 = new StringTokenizer(matriz1[i], ", ");
            for (int k = 0; k < columnas; k++) {
                String num = st1.nextToken();
                double ste = Double.parseDouble(num);
                matrizOriginal[i][k] = ste;
            }

        }
        return matrizOriginal;
    }

    public double[] capturaVector(String[] matriz1, int filas) {
        double[] matrizOriginal = new double[filas];
        for (int i = 0; i < filas; i++) {
            matrizOriginal[i] = Double.parseDouble(matriz1[i].trim());
        }
        return matrizOriginal;
    }

    public double[][] multiplicacion(double matriz1[][], double matriz2[][], int f1, int filasColumnas, int c2) {
        double matriz3[][] = new double[f1][c2];
        double entrada = 0;
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < filasColumnas; k++) {
                    entrada = entrada + (matriz1[i][k] * matriz2[k][j]);
                }
                matriz3[i][j] = entrada;
                entrada = 0;
            }
        }
        return matriz3;
    }

    public double[][] suma(double matriz1[][], double matriz2[][], int f1, int c1) {
        double matriz3[][] = new double[f1][c1];
        for (int i = 0; i < f1; i++) {
            for (int j = 0; j < c1; j++) {
                matriz3[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }

        return matriz3;

    }

    public String[][] capturaVector(String texto, int filas) {

        int cont1 = 0;
        String[][] matrizBorrador = new String[filas][1];
        StringTokenizer st = new StringTokenizer(texto, "\n");
        while (st.hasMoreTokens()) {
            matrizBorrador[cont1][1] = st.nextToken();
            cont1++;
        }
        return matrizBorrador;
    }

}
