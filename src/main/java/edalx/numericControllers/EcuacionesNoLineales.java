/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import edalx.methods.MethodsEcNoLineal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author edalx
 */
public class EcuacionesNoLineales {

    /**
     * @param args the command line arguments
     */
    public void biseccion() {
         EcuacionesNoLineales op = new EcuacionesNoLineales();
        Scanner leer = new Scanner(System.in);
        String function = "";
        String auxInt;
        double tol = 0;
        double inicPoint = 0;
        
        System.out.println("Ingrese la funcion:");
        function = leer.nextLine();
        System.out.println("Ingrese el intervalo [a,b] separado por una coma");
        auxInt = leer.nextLine();
        
        System.out.println("Ingrese la tolerancia");
        tol = Double.parseDouble(leer.nextLine());
       System.out.println("Ingrese el valor inicial");
        inicPoint = Double.parseDouble(leer.nextLine());
        MethodsEcNoLineal alg = new MethodsEcNoLineal();
        String[] intervalo = new String[2];
        double intA = 0;
        double intB = 0;
        double evalA = 0;
        double evalB = 0;
        double evalC = 0;
        double semSuma = 0;
        intervalo = auxInt.split(",");
        intA = Double.parseDouble(intervalo[0]);
        intB = Double.parseDouble(intervalo[1]);
        
        if (intA < intB) {
            while (intB - intA > tol) {
                semSuma = (intA + intB) / 2;
                evalC = alg.evalFunction(function, semSuma);
                evalA = alg.evalFunction(function, intA);
                if (evalC == 0) {
                    break;
                }
                if (evalC * evalA > 0) {
                    intA = semSuma;
                } else {
                    intB = semSuma;
                }

            }

        }
        System.out.println("La raiz de: " + function + " es: " + semSuma);
        System.out.println("La funcion evaluada en el punto es:" + alg.evalFunction(function, semSuma));

    }

    public void puntoFijo() {
         EcuacionesNoLineales op = new EcuacionesNoLineales();
        Scanner leer = new Scanner(System.in);
        String function = "";
        String auxInt="";
        double tol = 0;
        double inicPoint = 0;
        
        System.out.println("Ingrese la funcion:");
        function = leer.nextLine();
        System.out.println("Ingrese el intervalo [a,b] separado por una coma");
        auxInt = leer.nextLine();
        
        System.out.println("Ingrese la tolerancia");
        tol = Double.parseDouble(leer.nextLine());
       System.out.println("Ingrese el valor inicial");
        inicPoint = Double.parseDouble(leer.nextLine());
        MethodsEcNoLineal alg = new MethodsEcNoLineal();
        double evaluates = 0;
        boolean avl = true;
        double aux = 0;
        int cont=0;
        while(true){
            evaluates = alg.evalFunction(function, inicPoint);
            aux = Math.abs(inicPoint - evaluates);
            inicPoint = evaluates;
            if(aux<tol||evaluates==0){
                break;
            }
            if(cont>10&&aux>2){
                System.out.println("La función no es convergente");
                avl=false;
                break;
            }
            cont++;
          
        }
        
        if (avl) {
            System.out.println("La raiz es: "+evaluates);
        }
    }
    
    public void raphson (){
         EcuacionesNoLineales op = new EcuacionesNoLineales();
        Scanner leer = new Scanner(System.in);
        String function = "";
        String auxInt;
        double tol = 0;
        double inicPoint = 0;
        
        System.out.println("Ingrese la funcion:");
        function = leer.nextLine();
        System.out.println("Ingrese el intervalo [a,b] separado por una coma");
        auxInt = leer.nextLine();
        
        System.out.println("Ingrese la tolerancia");
        tol = Double.parseDouble(leer.nextLine());
       System.out.println("Ingrese el valor inicial");
        inicPoint = Double.parseDouble(leer.nextLine());
        MethodsEcNoLineal alg=new MethodsEcNoLineal();
        String derFunct=alg.derivate(function);
        double root=0;
        int cont=0;
        double aux=0;
        boolean key=true;
        while(true){
            System.out.println(cont+") "+inicPoint);
            root=inicPoint-(alg.evalFunction(function, inicPoint)/alg.evalFunction(derFunct, inicPoint));
            aux=Math.abs(root-inicPoint);
            if (aux<tol) {
                break;
            }
            if (cont>200||aux>5) {
                System.out.println("Posiblemente la función no converge");
                key=false;
                break;
            }
            inicPoint=root;
            cont++;  
        }
        if (key) {
            System.out.println((cont+1)+") "+root);
        }
        
    }

}
