/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import edalx.methods.IntegracionNumerica;
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class DerivacionNumerica {
    
    public void main() {
    IntegracionNumerica op=new IntegracionNumerica();
    Scanner leer=new Scanner(System.in);
    String function="";
    double point=0;
    double precision=0;
    double resultProg=0;
    double resultReg=0;
    double resultDifCentral=0;
    double resultDerivada2=0;
    int option=0;
    
        System.out.println("Ingrese la funcion que desea derivar: ");
        function=leer.nextLine();
        System.out.println("Ingrese el punto en el que deseea evaluar: ");
        point=Double.parseDouble(leer.nextLine());
        System.out.println("Ingrese la presicion de h: ");
        precision=Double.parseDouble(leer.nextLine());
        
        resultProg=(op.evalFunction(function, point+precision)-op.evalFunction(function, point))/precision;
        resultReg=(op.evalFunction(function, point)-op.evalFunction(function, point-precision))/precision;
        resultDifCentral=(op.evalFunction(function, point+precision)-op.evalFunction(function, point-precision))/(2*precision);
        resultDerivada2=(op.evalFunction(function, point+2*precision)-2*op.evalFunction(function, point)+op.evalFunction(function, point-2*precision));
        System.out.println("");
        System.out.println("************************************************************************");
        System.out.println("El resultado aproximado de la derivacion numerica es: ");
        System.out.println("");
        System.out.println("Progresiva: \t\t"+resultProg);
        System.out.println("Regresiva:\t\t"+resultReg);
        System.out.println("Diferencias Centrales: \t"+resultDifCentral);
        System.out.println("Segunda Derivada:\t"+resultDerivada2);
          
    } 
    
}
