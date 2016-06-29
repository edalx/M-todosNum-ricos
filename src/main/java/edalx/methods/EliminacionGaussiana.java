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
  
    public Double[] gaussSinPivote(Double[][] matriz, Double[] aumen){   
    Double[] result=new Double[aumen.length];
    double m=0;
        for (int i = 0; i < result.length-1; i++) {
            for (int k = i+1; k < result.length; k++) {
                if (matriz[i][i]==0) {
                    System.out.println("Existen ceros en la diagonal principal");
                }else{
                   
                m=matriz[k][i]/matriz[i][i];
                
                for (int j = 0; j< result.length; j++) {
                   matriz[k][j]=matriz[k][j]-m*matriz[i][j];
                }
                }
                
            }
        }
       return null; 
    }
}
