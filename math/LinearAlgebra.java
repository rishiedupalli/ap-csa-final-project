package math;

import java.util.*;
import org.apache.commons.math3.complex.*;
import org.apache.commons.math3.linear.*;

public class LinearAlgebra {
    public static FieldMatrix<Complex> ConstructVandermondeMatrix(int M, int N) {
        Complex MthRootOfUnity = Complex.valueOf(Math.cos(2 * Math.PI / M), Math.sin(2 * Math.PI / M));
        Complex[][] vandermondeMatrix = new Complex[N][N];
        for(int i = 0; i < N; i++) {
            Complex root = MthRootOfUnity.pow(2 * i + 1);
            System.out.println(" root for row " + i + ": " + root);
            for(int j = 0; j < N; j++) {
                System.out.print("V(" + i + ", " + j + "): " + root.pow(j) + " ");
                vandermondeMatrix[i][j] = root.pow(j);
            }
            System.out.println();
        }

        FieldMatrix<Complex> V = MatrixUtils.createFieldMatrix(vandermondeMatrix);
        return V;
    }
}
