import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Some Parameters
        final int M = 8;
        final int N = M / 2;
        final ComplexNumber MthRoot = new PolarComplexNumber().yieldNthRootOfUnity(M);
        ComplexNumber[] NthRootsOfUnity = new PolarComplexNumber().yieldNthRootsOfUnity(N);

        // print mth root of unity

        System.out.println("mth root of unity: " + MthRoot);
        // print nth roots of unity
        System.out.println("Nth roots of unity:");
        for (int i = 0; i < N; i++) {
            System.out.println(NthRootsOfUnity[i]);
        }
    }
}

/*
public Polynomial sigma_inverse(int M, ComplexNumber MthRoot, ComplexNumber[] plaintext) {
    ComplexNumber[][] V = LinearAlgebra.ConstructVandermondeMatrix(M, MthRoot, plaintext);
}
*/