package math;

import javax.xml.namespace.QName;

public class LinearAlgebra {
    public static ComplexNumber[][] ConstructVandermondeMatrix(int M, int N, ComplexNumber MthRootOfUnity, ComplexNumber[] vector) {
        ComplexNumber[][] V = new ComplexNumber[N][N];

        for (int i = 0; i < N; i++) {
            ComplexNumber root = MthRootOfUnity.exponentiate(new ComplexNumber(2 * i + 1, 0));
            for (int j = 0; j < N; j++) {
                V[i][j] = root.exponentiate(new ComplexNumber(j, 0));
            }
        }
        return V;
    }

    public static ComplexNumber[] solve(ComplexNumber[][] V, ComplexNumber[] b) {

    }
}