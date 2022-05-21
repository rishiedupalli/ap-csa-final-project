// java imports
import java.util.*;

// math imports
import math.*;

// encoding imports
import ckks.Encoder;


public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        // take input integer M verfify positive power of 2
        System.out.print("Enter M (Basis for Mth Root, basically basis for encryption. Positive integer M that is a power of 2): ");
        
        int M = Input.nextInt();
        while(M <= 0 || (M & (M - 1)) != 0) {
            System.out.println("Please enter a positive integer M that is a power of 2.");
            System.out.print("Enter M (Basis for Mth Root, basically basis for encryption. Positive integer M that is a power of 2): ");
            M = Input.nextInt();
        }

        ComplexNumber MthRootOfUnity = new PolarComplexNumber().getNthRootOfUnity(M);
        System.out.println("Mth Root of Unity (Main): " + MthRootOfUnity);

        int N = M / 2;

        ComplexNumber[] vectorA = new ComplexNumber[N];
        System.out.println("Enter vector (A) of M / 2 complex numbers");
        for(int i = 0; i < N; i++) {
            System.out.print("Real Part: ");
            double real = Input.nextDouble();
            System.out.print("Real Imaginary: ");
            double imaginary = Input.nextDouble();
            vectorA[i] = new ComplexNumber(real, imaginary);
            System.out.println();
        }

        Input.close();
        System.out.println("Vector A:");
        for(int i = 0; i < N; i++) {
            System.out.print(vectorA[i] + " ");
        }
        System.out.println();

        System.out.println("M is: " + M);
        Encoder CKKSEncoder = new Encoder(M, N, vectorA);
        Polynomial p1 = CKKSEncoder.sigma_inverse(vectorA);
        System.out.println("Polynomial p1: " + p1);
        ComplexNumber[] vectorB = CKKSEncoder.sigma(p1);
        System.out.println("Vector B:");
        for(int i = 0; i < N; i++) {
            System.out.println(vectorB[i] + " ");
        }
    }
}
