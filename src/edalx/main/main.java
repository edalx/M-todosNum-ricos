/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edalx.main;

import edalx.numericAlgoritms.*;
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class main {
    
    public static void main(String[] args) {
         VectoresOrtogonales alg=new VectoresOrtogonales();
        CambioDeBase op=new CambioDeBase();
        Scanner leer=new Scanner(System.in);
        
        System.out.println("                    Algoritmos Análisis Numérico");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Vectores ortogonales");
        System.out.println("2. Cambio de base");
        int opc=Integer.parseInt(leer.nextLine());
        switch(opc){
            case 1:
              alg.Ortogonales();
              break;
            case 2:
              op.mainBase();
              break;
            default:
                System.out.println("Ha ingresado una opcion incorrecta");
        }
        
   }
}
