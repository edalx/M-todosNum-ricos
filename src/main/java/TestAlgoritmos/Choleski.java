/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAlgoritmos;
import java.util.Arrays;

/**
 *
 * @author edalx
 */
public class Choleski {
    public static void main(String[] args) {
        double[][] A = {{4.0,1.0,2.0}, {1.0,2.0,0},{2.0,0,5.0}};
       // double[][] A={{1,2,3},{2,8,4},{3,4,11}};
        double[] b={1,2,4};
        FactorizacionDirectaCholesky(A,b,3);
    }

    public static void FactorizacionDirectaCholesky(double A[][], double[] b, int n){
        double [][] L = new double[n][n];
        double [][] U = new double[n][n];
      /* 
        for(int i=0;i<n;++i){
            for(int j=0;j<n;++j){
                if(i<j){
                   U[i][j] = Double.POSITIVE_INFINITY;
                   L[i][j] = 0;
                }else if(i>j){
                    L[i][j] = Double.POSITIVE_INFINITY;
                    U[i][j] = 0;
                }else if(i==j){
                    L[i][j] = Double.POSITIVE_INFINITY;
                    U[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }*/
        System.out.println("Factorización LU con el método Cholesky");
        System.out.println("Etapa 0");
        System.out.println("Matriz A");
        ImprimirMatriz(A, n);
        System.out.println("Matriz L");
        ImprimirMatriz(L, n);
        System.out.println("Matriz U");
        ImprimirMatriz(U, n);
      
         for(int k = 1; k < n+1; k++){
            System.out.println("Etapa #"+k);
            System.out.println("Hallar la Columna "+ k +" de L y la Fila "+ k +" de U");
            System.out.println("Matriz A");
            ImprimirMatriz(A, n);
            double Suma = 0;
            for(int p = 0; p < k-1; p++){
                Suma += L[k-1][p] * U[p][k-1];
            }
            U[k-1][k-1] = Math.sqrt(A[k-1][k-1] - Suma);
            L[k-1][k-1] = U[k-1][k-1];
            
            for(int j = k+1; j < n+1; j++){
                Suma = 0;
                for(int p = 0; p < k-1; p++){
                    
                    Suma += L[j-1][p] * U[p][k-1];
                }
                 L[j-1][k-1] = (A[j-1][k-1] - Suma) / L[k-1][k-1];
            }
            System.out.println("Matriz L");
            ImprimirMatriz(L, n);
            for(int i = k+1; i < n+1; i++){
                Suma = 0;
                for(int p = 0; p < k-1; p++){
                    Suma += L[k-1][p] * U[p][i-1];
                }
                U[k-1][i-1] = (A[k-1][i-1] - Suma)/L[k-1][k-1];
            } 
            System.out.println("Matriz U");
            ImprimirMatriz(U, n);
        }
        
        System.out.println("\n Sustitución Progresiva Lz = b");
        double[] z = SustitucionProgresiva(L, b);
        System.out.println("Z: " +Arrays.toString(z));
        System.out.println("\n Sustitución Regresiva Ux = z");
        double[] x = SustitucionRegresiva(U, z);
        for(int i = 0; i < x.length; ++i){
            System.out.println("X" + (i+1) + " = " + x[i]);
        }
    }
    
    public static double[] SustitucionProgresiva(double[][] L, double[] b){
        int n = L.length;
        double z[] = new double[n];
        for(int i = 1; i < n+1; ++i){
            double Suma = 0;
            for(int p = i-1; p > 0; --p){
                double a = L[i-2][p];
                double c = z[p-1];
                Suma += (L[i-1][p-1] * z[p-1]);
            }
            z[i-1] = (b[i-1] - Suma) / L[i-1][i-1];
        }
        return z;
    }

    public static double[] SustitucionRegresiva(double[][] U, double[] z){
        int n = U.length;
        double[] x = new double[n];       
        for(int i = n-1; i>=0; --i){
            double suma = 0;
            for(int j = i+1; j<n; ++j){
                suma += U[i][j] * x[j];
            }
            x[i] = (z[i]- suma) /U[i][i];
        }
        return x;
    }
    
    public static void ImprimirMatriz(double [][] matrix, int n){
        for(int i=0; i< n;++i){
            System.out.print("| ");
            for(int j=0; j <n; ++j){
                System.out.print(matrix[i][j]);
                addSpace(String.valueOf(matrix[i][j]).length(),20);
            }
            System.out.println(" |");  
        }
        System.out.println("----------------------------------------------------"
                + "-------------------------------------------");
    }
    
    public static void addSpace(int n, int k){
        if(n<k){
            for(int i = 0; i<k-n;++i){
                System.out.print(" ");
            }
        }
    }
}
