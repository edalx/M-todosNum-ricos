/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import java.util.Scanner;

/**
 *
 * @author edalx
 */
public class Interpolacion {
    public void InterpolateLagrange() {
        Scanner leer = new Scanner(System.in);
        int nPoints = 0;
        String[] coordenadas = new String[2];
        String auxPoints = "";
        double product=0;
        double inicPoint=0;
        double evalPol=0;
        System.out.println("Ingrese el número de puntos que desea interpolar");
        nPoints = Integer.parseInt(leer.nextLine());
        System.out.println("Ingrese el punto inicial");
        inicPoint=Double.parseDouble(leer.nextLine());
        double[] compX = new double[nPoints];
        double[] compY = new double[nPoints];
        double[] coefLag=new double[nPoints];
        System.out.println("Ingrese los puntos a interpolar");
        for (int i = 0; i < nPoints; i++) {
            auxPoints = leer.nextLine();
            coordenadas = auxPoints.split(";");
            compX[i]=Double.parseDouble(coordenadas[0]);
            compY[i]=Double.parseDouble(coordenadas[1]);            
        }
        for (int i = 0; i < nPoints; i++) {
          product=1;
            for (int j = 0; j < nPoints; j++) {
                if(i!=j){
                    product=product*((inicPoint-compX[j])/(compX[i]-compX[j]));
                }
            }
            coefLag[i]=product;
        }
        
        for (int i = 0; i < nPoints; i++) {
            evalPol=evalPol+coefLag[i]*compY[i];
        }
        System.out.println("El valor de la función evaluada en "+inicPoint+ " es "+evalPol);
        
    } 
    }
 
   