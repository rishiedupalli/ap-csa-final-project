package ckks;

// math imports
import math.*;

public class Encoder {
    int M;
    int N;
    ComplexNumber MthRootOfUnity = null;

    public Encoder(int M, int N, ComplexNumber[] vector) {
        this.M = M;
        this.N = N;
        MthRootOfUnity = new PolarComplexNumber().getNthRootOfUnity(M);
    }

    public Polynomial sigma_inverse(ComplexNumber[] b) {
        System.out.println("Mth Root: " + MthRootOfUnity);
        ComplexNumber[][] V = LinearAlgebra.ConstructVandermondeMatrix(M, N, MthRootOfUnity);

        ComplexNumber[] Coefficients = LinearAlgebra.solve(N, V, b);

        System.out.print("Coefficients: ");
        for(int i = 0; i < Coefficients.length; i++) {
            System.out.print("a_" + i + Coefficients[i] + " ");
        }

        return new Polynomial(Coefficients);
    }

    public ComplexNumber[] sigma(Polynomial p) {
        ComplexNumber[] vector = new ComplexNumber[N];
        for(int i = 0; i < N; i++) {
            ComplexNumber root = MthRootOfUnity.exponentiate(2 * 1 + 1);
            vector[i] = p.evaluate(root);
        }
        return vector;
    }
}
