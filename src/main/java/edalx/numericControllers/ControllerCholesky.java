
package edalx.numericControllers;

import edalx.methods.Choleski;
import edalx.models.defLU;

/**
 *
 * @author edalx
 */
public class ControllerCholesky {
    
    public static void main(String[] args) {
        Choleski method = new Choleski();
        defLU result = new defLU();
        double[][] A = {{4.0, 1.0, 2.0},
                        {1.0, 2.0, 0},
                        {2.0, 0, 5.0}};
        // double[][] A={{1,2,3},{2,8,4},{3,4,11}};
        double[] b = {1, 2, 4};
        if (method.isSquare(A)) {
            if (method.isSymmetric(A)) {
                
                result = method.FactorizacionCholesky(A, b, 3);
                if (result != null) {
                    
                    double[] z = method.SustitucionProgresiva(result.getL(), b);
                    //System.out.println("Y: " +Arrays.toString(z));
                    System.out.println("Y=");
                    for (int i = 0; i < z.length; i++) {
                        System.out.println("|\t" + z[i]);
                        
                    }
                    //System.out.println("\n Sustitución Regresiva Ux = z");
                    double[] x = method.SustitucionRegresiva(result.getU(), z);
                    System.out.println("----------------------------------------------------------------------------------------------------------------------");
                    System.out.println("");
                    System.out.println("X=");
                    
                    for (int i = 0; i < x.length; ++i) {
                        System.out.println("X" + (i + 1) + " = " + x[i]);
                    }
                } else {
                    System.out.println("");
                    System.out.println("*****************************************************************");
                    System.out.println("            La matriz es no definida positiva");
                    System.out.println("*****************************************************************");
                    System.exit(0);
                }
            } else {
                System.out.println("");
                System.out.println("*****************************************************************");
                System.out.println("            La matriz no es simetrica");
                System.out.println("*****************************************************************");

                System.exit(0);
            }
        } else {
            System.out.println("");
            System.out.println("*****************************************************************");
            System.out.println("            La matriz no es cuadrada");
            System.out.println("*****************************************************************");
            System.exit(0);
            
        }
    }
    
}
