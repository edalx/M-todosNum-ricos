/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import edalx.methods.IntegracionNumerica;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author Alexander
 */
public class DerivacionNumerica {

    public void solveDerivacion(String function, double point, double precision, JTextArea panel) {
        IntegracionNumerica op = new IntegracionNumerica();
        Scanner leer = new Scanner(System.in);
        double resultProg = 0;
        double resultReg = 0;
        double resultDifCentral = 0;
        double resultDerivada2 = 0;

        resultProg = (op.evalFunction(function, point + precision) - op.evalFunction(function, point)) / precision;
        resultReg = (op.evalFunction(function, point) - op.evalFunction(function, point - precision)) / precision;
        resultDifCentral = (op.evalFunction(function, point + precision) - op.evalFunction(function, point - precision)) / (2 * precision);
        resultDerivada2 = (op.evalFunction(function, point + 2 * precision) - 2 * op.evalFunction(function, point) + op.evalFunction(function, point - 2 * precision));
        panel.append("\nEl resultado aproximado de la derivacion numerica es: ");
        panel.append("\n");
        panel.append("\nProgresiva: \t\t" + resultProg);
        panel.append("\nRegresiva:\t\t" + resultReg);
        panel.append("\nDiferencias Centrales: \t" + resultDifCentral);
        panel.append("\nSegunda Derivada:\t" + resultDerivada2);

    }

}
