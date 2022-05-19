import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Some Parameters
        final int M = 8;
        final int N = M / 2;
        final ComplexNumber MthRoot = new PolarComplexNumber().yieldNthRootOfUnity(M);
    }
}

public Polynomial sigma_inverse(ComplexNumber MthRoot, Matrix[] plaintext) {

    VandermondeMatrix V = new VandermondeMatrix(MthRoot, plaintext);
}