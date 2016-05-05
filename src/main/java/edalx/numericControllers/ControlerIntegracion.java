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
public class ControlerIntegracion {

    public void main() {
        IntegracionNumerica operation = new IntegracionNumerica();
        Scanner leer = new Scanner(System.in);
        String function = "";
        double a = 1;
        double b = 0;
        double resultTrapecio = 0;
        double resultSimpson = 0;
        int partition = 0;
        int option = 0;
        System.out.println("");
        System.out.println("Ingrese la funcion que desea integrar:");
        function = leer.nextLine();
        while (true) {
            System.out.println("Ingrese los limites de la integral");
            System.out.println("Limite inferior:");
            a = Double.parseDouble(leer.nextLine());
            System.out.println("Limite superior:");
            b = Double.parseDouble(leer.nextLine());
            if (a < b) {
                break;
            }

            System.out.println("Se ha ingresado incorrectamente el intervalo");
        }
        System.out.println("");
        System.out.println("Elija un metodo de integracion numerica: ");
        System.out.println("1- Regla del Trapecio");
        System.out.println("2- Regla de Simpson 1/3");
        option = Integer.parseInt(leer.nextLine());

        switch (option) {
            case 1:
                while (true) {
                    System.out.println("Ingrese el numero de particiones: ");
                    partition = Integer.parseInt(leer.nextLine());
                    if (partition > 0) {
                        break;
                    }
                    System.out.println("El numero de particiones tiene que ser positivo");
                }
                resultTrapecio = operation.trapecio(function, a, b, partition);
                System.out.println("");
                System.out.println("***********************************************************************");
                System.out.println("Regla de Trapecios: Integrate(" + function + ")dx ~ " + resultTrapecio);
                System.out.println("***********************************************************************");
                break;

            case 2:
                while (true) {
                    System.out.println("Ingrese el numero de particiones: ");
                    partition = Integer.parseInt(leer.nextLine());
                    if (partition % 2 == 0 && partition > 0) {
                        break;
                    }
                    System.out.println("El numero de particiones tiene que ser par y positivo");
                }

                resultSimpson = operation.simpson1_3(function, a, b, partition);
                System.out.println("");
                System.out.println("***********************************************************************");
                System.out.println("Simpson 1/3 : Integrate(" + function + ")dx ~ " + resultSimpson);
                System.out.println("***********************************************************************");
                break;
            default:
                System.out.println("Ha ingresado una opcion invalida");
                
        }
        
        System.out.println("");
        System.out.println("");

    }
}
