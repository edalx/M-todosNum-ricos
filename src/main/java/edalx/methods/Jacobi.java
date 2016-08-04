
package edalx.methods;

import java.util.Arrays;
import javax.swing.JTextArea;

/**
 *
 * @author Alexander
 */
public class Jacobi {

    
    public double[] solve(double tol, double[] P, int maxIterations, double[][] M,JTextArea resultado) {
        int iterations = 1;
        int n = M.length;
        double var = 1000000000000.0;
        double[] X = new double[n];
        resultado.append("\nX_0" + " = {");
        for (int i = 0; i < n; i++) {
           resultado.append(P[i] + "\t");
        }
        resultado.append("}\n");
        while (true) {

            for (int i = 0; i < n; i++) {
                double sum = M[i][n]; // b_n

                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= M[i][j] * P[j];
                    }
                }
                if (M[i][i] != 0) {
                    X[i] = 1 / M[i][i] * sum;
                } else {
                    return null;
                }
            }

            resultado.append("X_" + iterations + " = {");
            for (int i = 0; i < n; i++) {
                resultado.append(X[i] + "\t");
            }
            resultado.append("}\n");

            iterations++;
            if (iterations == 1) {
                continue;
            }

            boolean stop = true;
            for (int i = 0; i < n && stop; i++) {
                if (Math.abs(X[i] - P[i]) > tol) {
                    if (Math.abs(X[i] - P[i]) < var) {
                        stop = false;
                    }
                }
                var = Math.abs(X[i] - P[i]);

            }

            if (stop || iterations == maxIterations) {
                break;
            }
            P = (double[]) X.clone();
        }
        return X;
    }
}
