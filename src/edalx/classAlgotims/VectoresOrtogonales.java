/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edalx.classAlgotims;

import edalx.methods.*;
import java.util.Scanner;

/**
 *
 * @author Alexander
 */
public class VectoresOrtogonales {

    /**
     * @param args the command line arguments
     */
    public void Ortogonales() {
        Scanner leer=new Scanner(System.in);
        OperacionesVectores vecOr=new OperacionesVectores();
        int numc1=0;
        int numc2=0;
        String arComp1[]=new String[2];
        String arComp2[]=new String[2];
        
       
        while(numc1!=2||numc2!=2){
        System.out.println("Ingrese los componentes de los vectores en R2 separados por una coma");
        System.out.println("* u1");
        String u1Comp=leer.nextLine();
        System.out.println("* u2");
        String u2Comp=leer.nextLine();
        arComp1=u1Comp.split(",|;");
        arComp2=u2Comp.split(",|;");
        numc1=arComp1.length;
        numc2=arComp2.length;
        
            if (numc1!=2||numc2!=2) {
                System.out.println("\nHa ingreso de manera incorrecta los datos");
            }
    }
        
        Double[] cmvector1=new Double[numc1];
        Double[] cmvector2=new Double[numc2];
        
        for (int i = 0; i < numc2; i++) {
           cmvector1[i]=Double.parseDouble(arComp1[i]);
           cmvector2[i]=Double.parseDouble(arComp2[i]);
        }        
        
        double determ=0;
        double multco=0;
        double nvector1=0;
        double nvector2=0;
        double angulo=0;
        double lamda=0;
        Double[] cmvector3=new Double[numc1]; 
        Double[] cmvector4=new Double[numc1];
        double lamda2=0;
        if((cmvector1[0]!=0||cmvector1[1]!=0)&&(cmvector2[0]!=0||cmvector2[1]!=0)){
              determ=cmvector1[0]*cmvector2[1]-cmvector1[1]*cmvector2[0];
              if(determ!=0){
                  nvector1=vecOr.normaVector(cmvector1);
                  nvector2=vecOr.normaVector(cmvector2);
                  multco=vecOr.productoEscalar(cmvector1, cmvector2);
                  angulo=Math.acos(multco/(nvector1*nvector2));
                  lamda=multco/Math.pow(nvector1,2);
                  cmvector3[0]=cmvector2[0]-lamda*cmvector1[0];
                  cmvector3[1]=cmvector2[1]-lamda*cmvector1[1];
                  System.out.println("\n\nEl ángulo entre los vectores es: "+angulo);
                  System.out.println("Vector v1: ("+cmvector1[0]+","+cmvector1[1]+")");
                  System.out.println("Vector v2: ("+cmvector3[0]+","+cmvector3[1]+")");
                  System.out.println("\n\nProyección sobre el segundo vector");
                  System.out.println("----------------------------------------------");
                  lamda2=multco/Math.pow(nvector2,2);
                  cmvector4[0]=cmvector1[0]-lamda2*cmvector2[0];
                  cmvector4[1]=cmvector1[1]-lamda2*cmvector2[1];
                  System.out.println("Vector v1: ("+cmvector2[0]+","+cmvector2[1]+")");
                  System.out.println("Vector v2: ("+cmvector4[0]+","+cmvector4[1]+")");
              }else{
                  System.out.println("\nLos vectores son colineales");
              }
        }else{
            System.out.println("\nAlguno de los vectores es nulo!!");
            
        }

    }
    
}
