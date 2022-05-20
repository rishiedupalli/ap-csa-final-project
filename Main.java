import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Some Parameters
        final int M = 8;
        final int N = M / 2;
        final ComplexNumber MthRoot = new PolarComplexNumber().yieldNthRootOfUnity(M);
        ComplexNumber[] NthRootsOfUnity = new PolarComplexNumber().yieldNthRootsOfUnity(N);

        ComplexNumber[] vector = new ComplexNumber[N];
        for (int i = 0; i < N; i++) {
            vector[i] = new ComplexNumber(i+1, 0);
        }

        Polynomial p = sigma_inverse(M, MthRoot, vector);
        System.out.println(p);
        ComplexNumber[] Output = sigma(M, p, MthRoot);
        
        for (ComplexNumber v_i : Output) {
            System.out.println(v_i);
        }

        // print mth root of unity

        // System.out.println("mth root of unity: " + MthRoot);
        // // print nth roots of unity
        // System.out.println("Nth roots of unity:");
        // for (int i = 0; i < N; i++) {
        //     System.out.println(NthRootsOfUnity[i]);
        // }
    }

    public static Polynomial sigma_inverse(int M, ComplexNumber MthRoot, ComplexNumber[] plaintext){
        ComplexNumber[][] V = LinearAlgebra.ConstructVandermondeMatrix(M, MthRoot, plaintext);
    
        ComplexNumber[] PolynomialCoeffs = LinearAlgebra.Solve(V, plaintext);
        return new Polynomial(PolynomialCoeffs);
    }

    public static ComplexNumber[] sigma(int M, Polynomial p, ComplexNumber MthRoot) {
        ComplexNumber[] outputs = new ComplexNumber[M / 2];
        for (int i = 0; i < M / 2; i++) {
            outputs[i] = p.evaluate(MthRoot.pow(2 * i + 1));
        }
        return outputs;
    }


}



