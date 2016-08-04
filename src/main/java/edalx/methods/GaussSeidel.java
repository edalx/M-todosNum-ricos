package edalx.methods;

import java.util.Arrays;
import javax.swing.JTextArea;

/**
 *
 * @author Alexander
 */
public class GaussSeidel {

    public double[] solve(double[][] M, double b[], double X[], int maxIterations, double tol, JTextArea resultado) {
        int iterations = 1;
        int n = M.length;

        double sum;
        double P[];
        resultado.append("X_0" + " = {");
        for (int i = 0; i < n; i++) {
            resultado.append(X[i] + "\t");
        }
        double var = 1000000000000.0;
        resultado.append("}\n");
        while (true) {
            P = (double[]) X.clone();
            for (int i = 0; i < n; i++) {
                sum = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum = sum + M[i][j] * X[j];
                    }
                }
                if (M[i][i] != 0) {
                    X[i] = (b[i] - sum) / M[i][i];
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
                       
                    }
                }
                var = Math.abs(X[i] - P[i]);
            }

            if (stop || iterations == maxIterations) {
                break;
            }

        }
        return X;
    }
}
