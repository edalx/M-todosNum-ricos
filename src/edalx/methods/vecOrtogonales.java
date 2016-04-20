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
public class vecOrtogonales {
    public double normaVector(Double[] vector){
        double norma=0;  
        double scnorma=0; //suma de los componentes al cuadrado
        for (Double comVect : vector) {
            scnorma=scnorma+Math.pow(comVect,2);
        }
        norma=Math.sqrt(scnorma);
        return norma;
}
}
