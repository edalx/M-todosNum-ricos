/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import edalx.methods.Bases;
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class CambioDeBase {

    public void mainBase() {
        System.out.println("");
        System.out.println("");
        System.out.println("-----Cambio de base-----");
        Bases nuevo = new Bases();
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese un número:");
        String cadenaNum = leer.next();
        System.out.println("Ingrese la base original:");
        String baseNum = leer.next();
        System.out.println("Ingrese la base a la que quiere transformar:");
        String baseCambio = leer.next();
        int baseO = Integer.parseInt(baseNum);
        int baseC= Integer.parseInt(baseCambio);
        String[] coefNumString = new String[cadenaNum.length()];
        Double resultBase10;
        String resultFinal="";

        for (int i = 0; i < cadenaNum.length(); i++) {
            Character sep = cadenaNum.charAt(cadenaNum.length() - (i + 1));
            coefNumString[i] = sep.toString();
        }
        
        resultBase10 = nuevo.baseM_base10(coefNumString, baseO);
        Integer snComa=Integer.parseInt(resultBase10.toString().substring(0, resultBase10.toString().length()-2));  
        Integer[] coefNum = new Integer[snComa.toString().length()];
        int aux=0;
        System.out.println(""+snComa);
        System.out.println(""+resultBase10);
        for (int i = 0; i < snComa.toString().length(); i++) {
            Character sep = snComa.toString().charAt(snComa.toString().length() - (i + 1));
            aux=Integer.parseInt(sep.toString());
            coefNum[i]=aux;
            System.out.println("--"+aux);
        }
        
        resultFinal= nuevo.base10_baseN(coefNum, baseC);
        System.out.println("El numero ( "+cadenaNum+" )"+baseNum+" es igual a ( "+resultFinal+" )"+baseCambio);
    }
}
