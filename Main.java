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

        int N = M / 2;

        // take input vector of complex numbers
        ComplexNumber[] vectorA = new ComplexNumber[N];
        System.out.println("Enter vector (A) of complex numbers");
        for(int i = 0; i < N; i++) {
            System.out.print("Real Part: ");
            double real = Input.nextDouble();
            System.out.print("Real Imaginary: ");
            double imaginary = Input.nextDouble();
            vectorA[i] = new ComplexNumber(real, imaginary);
            System.out.println();
        }

        Encoder CKKSEncoder = new Encoder(M, N, vectorA);
        Polynomial p1 = CKKSEncoder.sigma_inverse(vectorA);
    }
}
