package ckks;

// math imports
import math.*;

public class Encoder {
    int M;
    int N;
    ComplexNumber MthRootOfUnity = new PolarComplexNumber().getNthRootOfUnity(M);

    public Encoder(int M, int N, ComplexNumber[] vector) {
        this.M = M;
        this.N = N;
    }

    public Polynomial sigma_inverse(ComplexNumber[] b) {
        ComplexNumber[][] V = LinearAlgebra.ConstructVandermondeMatrix(M, N, MthRootOfUnity);

        ComplexNumber[] Coefficients = LinearAlgebra.solve(N, V, b);

        return new Polynomial(Coefficients);
    }
}
