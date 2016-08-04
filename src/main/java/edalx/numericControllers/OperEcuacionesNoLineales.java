/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import edalx.methods.MethodsEcNoLineal;
import javax.swing.JTextArea;

/**
 *
 * @author edalx
 */
public class OperEcuacionesNoLineales {

    public OperEcuacionesNoLineales() {
    }

    public void biseccion(String function, String auxInt, double tol, JTextArea panel) {
        OperEcuacionesNoLineales op = new OperEcuacionesNoLineales();
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
        double aux1 = 0;
        double aux2 = 0;

        if (intA < intB) {
            aux1 = alg.evalFunction(function, intA);
            aux2 = alg.evalFunction(function, intB);
            if (aux1 * aux2 < 0) {
                panel.append("a\t\tb\tc\td\n");
                panel.append(intA + "\t" + "\t" + intB + "\t" + semSuma + "\t" + (intB - intA) + "\n");
                while (intB - intA > tol) {
                    semSuma = (intA + intB) / 2;

                    evalC = alg.evalFunction(function, semSuma);
                    evalA = alg.evalFunction(function, intA);
                    panel.append(intA + "\t" + "\t" + intB + "\t" + semSuma + "\t" + (intB - intA) + "\n");
                    if (evalC == 0) {
                        break;
                    }
                    if (evalC * evalA > 0) {
                        intA = semSuma;
                    } else {
                        intB = semSuma;
                    }

                }

                panel.append("\n");
                panel.append("La raiz de: " + function + " es: " + semSuma + "\n");
                panel.append("La funcion evaluada en el punto es:" + alg.evalFunction(function, semSuma) + "\n");
            } else {
                panel.append("La función en los extremos del intervalo no cumple el teorema de Bolzano");
            }
        }

    }

    public void pfijo(String funcion, double x, double tol, int iter, JTextArea panel) {
        MethodsEcNoLineal alg = new MethodsEcNoLineal();
        String message = "";
        double fx = 0;
        fx = alg.evalFunction(funcion, x);
        double error = tol + 1;
        double xn;
        panel.append("\txi\t" + "f(xi+1)\n");
        for (int i = 0; i < iter && fx != 0 && error > tol; i++) {
            xn = alg.evalFunction(funcion, x);
            error = Math.abs(xn - x);
            x = xn;
            fx = alg.evalFunction(funcion, x);
            message = x + "   " + fx + "   " + "\n";

            panel.append((i + 1) + ")  " + message+"\n");
        }

        if (fx == 0) {
             panel.append( "la raíz es " + x+"\n");
        } else if (error < tol) {
            panel.append("la raíz es " + x + " con una tolerancia de " + tol+"\n");
        } else {
            panel.append("el método fracaso en " + iter + " iteraciones \n");
        }

    }

    public void raphson(String function, double tol, double inicPoint, JTextArea panel) {
        OperEcuacionesNoLineales op = new OperEcuacionesNoLineales();
        MethodsEcNoLineal alg = new MethodsEcNoLineal();
        String derFunct = alg.derivate(function);
        double root = 0;
        int cont = 1;
        double aux = 0;
        boolean key = true;
        panel.append("xi" + "\t\t\t" + "f" + "(xi+1)\n");
        while (true) {

            root = inicPoint - (alg.evalFunction(function, inicPoint) / alg.evalFunction(derFunct, inicPoint));

            panel.append(cont + ")   " + inicPoint + "\t\t" + alg.evalFunction(function, inicPoint) + "\n");
            aux = Math.abs(root - inicPoint);
            if (aux < tol) {
                key = false;
                break;
            }

            inicPoint = root;
            cont++;
        }
        if (key) {
            panel.append("Posiblemente la función no converge o se necesitan mas iteraciones");
        }else{
            panel.append("\nLa raiz de la ecuación es: "+root);
        }

    }

}
