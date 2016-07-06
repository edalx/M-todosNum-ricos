/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.methods;

/**
 *
 * @author edalx
 */
public class EliminacionGaussiana {

    public Double[] gaussSinPivote(Double[][] matriz, Double[] coef) {
        Double[] result = new Double[coef.length];
        Double[][] aumen = new Double[coef.length][coef.length + 1];
        Double[] x = new Double[coef.length];
        for (int i = 0; i < coef.length; i++) {
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

    public void printMatrizAumen(Double[][] aumen) {

        for (int i = 0; i < aumen.length; i++) {
            for (int j = 0; j < aumen.length + 1; j++) {
                System.out.print("\t" + aumen[i][j]);
            }
            System.out.println("");

        }
    }

    /*  public static void main(String[] args) {
        Double[][] a = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}};
        Double[] coef = {1.0, 2.0, 3.0};
        Double[] result = gaussSinPivote(a, coef);
    }*/
    public Double[] PartialPivoting(Double[][] matriz, Double[] coef) {
        int r = 0;
        double aux;
        double aux1;
        double m = 0;
        int n = coef.length;
        //Carga matriz aumentada
        Double[] result = new Double[coef.length];
        Double[][] aumen = new Double[n][n + 1];
        Double[] x = new Double[n];
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
            for (int j = i + 1; j < coef.length; j++) {
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
                    System.out.println("Existen ceros en la diagonal superior");
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
                    if(aumen[i][i]==aumen[i][j]){
                        aumen[k][j]=0.0;
                    }else{
                        aumen[k][j] = aumen[k][j] - aux * aumen[i][j];
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
}
