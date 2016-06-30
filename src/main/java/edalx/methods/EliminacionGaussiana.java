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

    public Double[] gaussSinPivote(Double[][] matriz, Double[] aumen) {
        Double[] result = new Double[aumen.length];
        double m = 0;
        double aux = 0;
        for (int i = 0; i < result.length - 1; i++) {
            for (int k = i + 1; k < result.length; k++) {
                if (matriz[i][i] == 0) {
                    System.out.println("Existen ceros en la diagonal principal");
                    System.exit(0);
                } else {

                    m = matriz[k][i] / matriz[i][i];
                    matriz[k][i] = 0.0;
                    for (int j = i + 1; j < result.length; j++) {
                        matriz[k][j] = matriz[k][j] - m * matriz[i][j];
                    }

                    aumen[k] = aumen[k] - m * aumen[i];

                }

            }
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = 0.0;
        }

        for (int i = aumen.length - 1; i >= 0; i--) {
            aux = 0;
            for (int j = i + 1; j < result.length; j++) {
                aux = aux + matriz[i][j] * result[j];
            }
            result[i] = (aumen[i] - aux) / matriz[i][i];
        }
        return result;

    }
    
    public Double[] PartialPivoting(Double[][] A, Double[] b){
        int r=0;
        double aux1;
        double aux2;
        double m = 0;
        double aux = 0;
        Double[] result = new Double[b.length];
        for (int i = 0; i < b.length-1; i++) {
            r=i;
            for (int j = i+1; j < b.length; j++) {
                if (A[j][i]>A[r][j]) {
                    r=i;
                }
            }
            if (A[r][i]==0) {
                System.out.println("El sistema no tiene solucion unica");
            }
            for (int k = 0; k < b.length; k++) {
                aux1=A[i][k];
                A[i][k]=A[r][k];
                A[r][k]=aux1;
                
                aux2=b[r];
                b[r]=b[i];
                b[i]=aux2;
            }
            
            for (int k = i + 1; k < result.length; k++) {
                if (A[i][i] == 0) {
                    System.out.println("Existen ceros en la diagonal principal");
                    System.exit(0);
                } else {

                    m = A[k][i] / A[i][i];
                    A[k][i] = 0.0;
                    for (int j = i + 1; j < result.length; j++) {
                        A[k][j] = A[k][j] - m * A[i][j];
                    }

                    b[k] = b[k] - m * b[i];

                }

            }
        }
        
        for (int i = 0; i < result.length; i++) {
            result[i] = 0.0;
        }

        for (int i = b.length - 1; i >= 0; i--) {
            aux = 0;
            for (int j = i + 1; j < result.length; j++) {
                aux = aux + A[i][j] * result[j];
            }
            result[i] = (b[i] - aux) / A[i][i];
        }
        return result;
    }
}
