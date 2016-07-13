/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestAlgoritmos;

/**
 *
 * @author edalx
 */
public class PivoteTotal {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        //double[][] matriz = {{6.0,-2.0,2.0,4.0,12.0}, {12.0,-8.0,6.0,10.0,34.0}, {3.0,-13.0,9.0,3.0,27.0},{-6.0,4.0,1.0,-18.0,-38.0}};
       double[][] matriz = {{1.0,2,3,1.0}, {4,5,6,2.0},{7,8,9,3}};
        eliminacionGaussianaPivoteoTotal(3,matriz);
    }
        public static void eliminacionGaussianaPivoteoTotal(int n, double[][] matriz){   
        System.out.println("ELIMINACIÓN GAUSSIANA CON PIVOTEO TOTAL");
        System.out.println("Matriz Original");
        int[] marcas = Marcas(n);
        ImprimirMatriz(matriz,n,marcas);
        for(int k = 1; k < n; ++k){
            System.out.println("Etapa "+ k);
            pivoteoTotal(matriz, marcas, k, n);
            System.out.println("Objetivo de la Etapa: Hacer ceros los elementos "
                                 + "debajo del elemento A"+ 
                    
                                k +","+k + "= " + matriz[k-1][k-1]);
            System.out.println("\nMultiplicadores:");
            for(int i = k+1; i < n+1; ++i){
                double multiplicador = matriz[i-1][k-1]/matriz[k-1][k-1];
                for(int j = k ; j < n+2; ++j){
                    matriz[i-1][j-1] = matriz[i-1][j-1] - multiplicador*matriz[k-1][j-1];
                    if(i==j&&matriz[i-1][j-1]==0){
                        System.out.println("");
                        System.out.println("Existen ceros en la diagonal principal elemento "+i+","+j);
                        System.out.println("El sistema tiene infinitas soluciones");
                        ImprimirMatriz(matriz,n,marcas);
                        System.exit(0);
                    }
                }
                System.out.println("Multiplicador "+ i+","+k +" : " + multiplicador);
            }
            System.out.println(" ");
            ImprimirMatriz(matriz,n,marcas);
        }
        double x[] = new double[n];
        System.out.println("Resultado");
        for(int i = n; i>0;--i){
                double sumatoria = 0;
                for(int p = i+1; p <= n; ++p){
                        sumatoria = sumatoria + matriz[i-1][p-1]*x[p-1];
                }
                x[i-1] = (matriz[i-1][n]-sumatoria)/matriz[i-1][i-1];
                System.out.println( "X"+marcas[i-1]+" = "+x[i-1]);
        }
    }    
    public static int[] Marcas(int n){
        int[] marcas = new int[n];
        for(int i = 0; i < n; ++i){
            marcas[i] = i+1;
        }
        return marcas;
    }    
     public static double[][] pivoteoTotal(double[][] matriz, int[] marcas, int k, int n){
        double mayor = 0;
        int FilaMayor = k-1;
        int ColumnaMayor = k-1;
        for(int y = k-1; y < n; ++y){
            for(int x = k-1; x < n; ++x){
                if(Math.abs(matriz[y][x]) > mayor){
                    mayor = Math.abs(matriz[y][x]);
                    FilaMayor = y;
                    ColumnaMayor = x;
                }
            }
        }
        System.out.println("Elemento Mayor: " + mayor + " en la fila "+ 
                    (FilaMayor + 1) + " y la columna "+ (ColumnaMayor+1));
        if(mayor == 0){
            System.out.println("El sistema no tiene solución única.");
            System.exit(0);
        }else{
            if(FilaMayor != k-1){
                System.out.println("Cambio de fila "+ k + " con fila " + 
                                    (FilaMayor+1));
                for(int i = 0; i < matriz[0].length; i++){
                    double aux = matriz[k-1][i];
                    matriz[k-1][i] = matriz[FilaMayor][i];
                    matriz[FilaMayor][i] = aux;
                }
                ImprimirMatriz(matriz, n,marcas);
            }
            if(ColumnaMayor != k-1){
                System.out.println("Cambio de columna "+ k + " con la columna " +
                                    (ColumnaMayor+1));
                for(int i = 0; i < n; i++){
                    double aux = matriz[i][k-1];
                    matriz[i][k-1] = matriz[i][ColumnaMayor];
                    matriz[i][ColumnaMayor] = aux;
                }
                int aux2 = marcas[ColumnaMayor];
                marcas[ColumnaMayor] = marcas[k-1];
                marcas[k-1] = aux2;
                ImprimirMatriz(matriz, n,marcas);
            }
        }
        return matriz;
    }
    public static void ImprimirMatriz(double [][] matrix, int n, int [] marcas){
        for(int i = 0;i<n;i++){
            System.out.print("X"+marcas[i]);
            addSpace(String.valueOf(marcas[i]).length(), 30);
        }
        System.out.print("\n");
        for(int i=0; i< n;i++){
            for(int j=0; j <n+1; j++){
                System.out.print(matrix[i][j]);
                addSpace(String.valueOf(matrix[i][j]).length(),30);
            }
            System.out.print("\n");
        }
        System.out.println("");
    }    
    public static void addSpace(int n, int k){
        if(n<k){
            for(int i = 0; i<k-n;i++){
                System.out.print(" ");
            }
        }
    }
    
    
}
