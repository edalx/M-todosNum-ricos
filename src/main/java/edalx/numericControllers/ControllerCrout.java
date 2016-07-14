/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import edalx.methods.Choleski;
import edalx.methods.EliminacionGaussiana;
import edalx.methods.SistemasdeEcuaciones;
import edalx.models.defLU;

/**
 *
 * @author edalx
 */
public class ControllerCrout {

    public static void main(String[] args) {
        SistemasdeEcuaciones method = new SistemasdeEcuaciones();
        Choleski m2 = new Choleski();
        defLU result = new defLU();
        EliminacionGaussiana m3=new EliminacionGaussiana();
        //Double[][] A = {{60.0, 30.0, 20.0}, {30.0, 20.0, 15.0}, {20.0, 15.0, 12.0}};
        //double[][] A = {{2, 4, 6}, {4, 8, 12}, {8, 16, 24}};

        double[][] A = {{2.0, -2.0, 0.0, 2.0, 0.0}, {1.0, 0.0, -1.0, 2.0, 0.0}, {-1.0, 2.0, 1.0, 4.0, -2.0}, {2.0, -3.0, 0.0, 1.0, 1.0}, {0.0, -1.0, 1.0, 0.0, -1.0}};
        double[] b = {0, 0, 0, -2, 1};
        int n=b.length;
        double [] y=new double[n];
        double[] x=new double[n];

        result = method.factorizacionLU(A);
        y=m3.gaussSinPivote(result.getL(), b);
        x=m3.gaussSinPivote(result.getU(), y);
        
        for (int i = 0; i < x.length; i++) {
            System.out.println("x"+(i+1)+"="+x[i]);            
        }
        

    }
}
