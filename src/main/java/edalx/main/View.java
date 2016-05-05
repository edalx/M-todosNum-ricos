/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edalx.main;

import edalx.numericControllers.CambioDeBase;
import edalx.numericControllers.ControlerIntegracion;
import edalx.numericControllers.DerivacionNumerica;
import edalx.numericControllers.VectoresOrtogonales;
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class View {
    
    public static void main(String[] args) {
        VectoresOrtogonales alg=new VectoresOrtogonales();
        CambioDeBase op=new CambioDeBase();
        ControlerIntegracion integra=new ControlerIntegracion();
        DerivacionNumerica deriva=new DerivacionNumerica();
        Scanner leer=new Scanner(System.in);
        System.out.println("");
        System.out.println("");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("                    ALGORITMOS DE ANALISIS NUMERICO");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("Seleccione una opcion:");
        System.out.println("1. Vectores ortogonales");
        System.out.println("2. Cambio de base");
        System.out.println("3. Integracion numerica");
        System.out.println("4. Derivacion numerica");
        int opc=Integer.parseInt(leer.nextLine());
        switch(opc){
            case 1:
              alg.Ortogonales();
              break;
            case 2:
              op.mainBase();
              break;
            case 3:
              integra.main();
              break;
            case 4:
                deriva.main();
                break;
            default:
                System.out.println("Ha ingresado una opcion incorrecta");
        }
        
   }
}
