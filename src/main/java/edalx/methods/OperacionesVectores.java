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
public class OperacionesVectores {
    public double normaVector(Double[] vector){
        double norma=0;  
        double scnorma=0; //suma de los componentes al cuadrado
        for (Double comVect : vector) {
            scnorma=scnorma+Math.pow(comVect,2);
        }
        norma=Math.sqrt(scnorma);
        return norma;
}
    public double productoEscalar(Double[] vect1, Double[] vect2){
        double varResult=0;
        for (int i = 0; i < vect1.length; i++) {
            varResult=varResult+vect1[i]*vect2[i];            
        }
        return varResult;
        
    }
}
