import java.util.*;
import org.apache.commons.math3.complex.*;
import org.apache.commons.math3.linear.*;

import math.*;

import ckks.*;

public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("CKKS Encoder/Decoder (V \\in C^n -> C[X]/(X^n + 1) -> V \\in C^n)");

        final int M = 8;
        final int N = M / 2;

        Complex[] vectorAElements = new Complex[N];
        Complex[] vectorBElements = new Complex[N];

        System.out.println("Enter vector A (M / 2): ");
        for(int i = 0; i < N; i++) {
            System.out.println("Real part of element " + (i + 1) + ": ");
            vectorAElements[i] = new Complex(Input.nextDouble(), 0);
            System.out.println("Imaginary part of element " + (i + 1) + ": ");
            vectorAElements[i] = vectorAElements[i].add(new Complex(0, Input.nextDouble()));
        }

        System.out.println("Enter vector B (M / 2): ");
        for(int i = 0; i < N; i++) {
            System.out.println("Real part of element " + (i + 1) + ": ");
            vectorBElements[i] = new Complex(Input.nextDouble(), 0);
            System.out.println("Imaginary part of element " + (i + 1) + ": ");
            vectorBElements[i] = vectorBElements[i].add(new Complex(0, Input.nextDouble()));
        }

        Input.close();

        FieldVector<Complex> vectorA = new ArrayFieldVector<Complex>(vectorAElements);
        FieldVector<Complex> vectorB = new ArrayFieldVector<Complex>(vectorBElements);

        Encoder CKKSEncoder = new Encoder(M, N);

        Polynomial p1 = CKKSEncoder.sigma_inverse(vectorA);
        Polynomial p2 = CKKSEncoder.sigma_inverse(vectorB);
        Polynomial p3 = p1.addPolynomial(p2);

        Complex[] decode = CKKSEncoder.sigma(p3);

        // print out vector A and B in one line and then decode
        for (Complex a : vectorAElements) {
            System.out.print(a + " ");
        }
        System.out.println(" + ");
        for (Complex b : vectorBElements) {
            System.out.print(b + " ");
        }

        System.out.println(" = ");
        System.out.println("p1: " + p1);
        System.out.println(" + ");
        System.out.println("p2: " + p2);
        System.out.println(" = ");

        for (Complex d : decode) {
            System.out.print(d + " ");
        }
    }
}