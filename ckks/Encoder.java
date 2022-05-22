package ckks;

import java.util.*;

import org.apache.commons.math3.complex.*;
import org.apache.commons.math3.analysis.polynomials.*;
import org.apache.commons.math3.linear.*;

import math.*;

public class Encoder {
    int M;
    int N;
    Complex MthRootOfUnity;

    public Encoder(int M, int N) {
        this.M = M;
        this.N = N;
        this.MthRootOfUnity = Complex.valueOf(Math.cos(2 * Math.PI / M), Math.sin(2 * Math.PI / M));
    }

    public Polynomial sigma_inverse(FieldVector<Complex> b) {
        FieldMatrix<Complex> V = LinearAlgebra.ConstructVandermondeMatrix(M, N);
        FieldLUDecomposition<Complex> Solver = new FieldLUDecomposition<Complex>(V);
        FieldVector<Complex> Coeffs = Solver.getSolver().solve(b);

        System.out.println("Coefficients: ");
        for(int i = 0; i < N; i++) {
            System.out.println("Coeff " + i + ": " + Coeffs.getEntry(i));
        }

        Polynomial p = new Polynomial(Coeffs);
        return p;
    }

    public Complex[] sigma(Polynomial p) {
        Complex[] output = new Complex[N];
        for(int i = 0; i < N; i++) {
            output[i] = p.eval(MthRootOfUnity.pow(2 * i + 1));
        }
        return output;
    }
}
