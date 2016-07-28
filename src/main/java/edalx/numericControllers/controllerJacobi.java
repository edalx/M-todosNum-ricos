/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edalx.numericControllers;

import edalx.methods.Jacobi;

/**
 *
 * @author Alexander
 */
public class controllerJacobi {
      public static void main(String[] args) {
        
    
     /* double[][] M = {{10.0, 2, 1, 7},
        {1, 5, 1, -8},
        {2, 3, 10, 6}};
        double[] X = {0.7, -1.6, 0.6};*/
       /* double[][] M = {{5, 1, 11},
                        {2, 10, 12}};
        double[] X = {0.5, 0.5};//*/
       double[][] M = {{5,-2,1,3},
                       {-1,-7,3,-2},
                       {2,-1,8,1}
       };
                   
       double[] X = {0,0,0};
        double tol = 0.000001;
        int maxIterations=100;
        Jacobi method=new Jacobi();
        


        if (!method.verifyDominant(M)) {
            System.out.println("**************************************************************************************");
            System.out.println("              El método no es convergente o faltan iteraciones");
            System.out.println("**************************************************************************************");
        }else{

        System.out.println("Matriz A");
        method.print(M);
        System.out.println("");
        method.solve(tol, X,maxIterations,M);
    }
      }
}
