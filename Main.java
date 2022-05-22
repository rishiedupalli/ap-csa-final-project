import java.util.*;
import org.apache.commons.math3.complex.*;
import org.apache.commons.math3.linear.*;

import math.*;

import ckks.*;

public class Main {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        System.out.println("CKKS Encryption");

        System.out.print("Enter M ( M > 1 && M % 2 = 0): ");
        int M = Input.nextInt();
        while(M <= 1 || M % 2 != 0) {
            System.out.print("Enter M ( M > 1 && M % 2 = 0): ");
            M = Input.nextInt();
            System.out.println();
        }

        final int N = M / 2;

        Complex[] vectorAElements = new Complex[N];
        Complex[] vectorBElements = new Complex[N];

        System.out.println("Enter vector A (M / 2): ");
        for(int i = 0; i < N; i++) {
            System.out.println("Real part of element" + (i + 1) + ": ");
            vectorAElements[i] = new Complex(Input.nextDouble(), 0);
            System.out.println("Imaginary part of element" + (i + 1) + ": ");
            vectorAElements[i] = vectorAElements[i].add(new Complex(0, Input.nextDouble()));
        }

        FieldVector<Complex> vectorA = new ArrayFieldVector<Complex>(vectorAElements);

        System.out.println("Enter vector B (M / 2): ");
        for(int i = 0; i < N; i++) {
            System.out.println("Real part of element" + (i + 1) + ": ");
            vectorBElements[i] = new Complex(Input.nextDouble(), 0);
            System.out.println("Imaginary part of element" + (i + 1) + ": ");
            vectorBElements[i] = vectorBElements[i].add(new Complex(0, Input.nextDouble()));
        }
        
        FieldVector<Complex> vectorB = new ArrayFieldVector<Complex>(vectorBElements);
        Encoder CKKSEncoder = new Encoder(M, N);
        Polynomial p1 = CKKSEncoder.sigma_inverse(vectorA);
        System.out.println("p1: " + p1);
        Polynomial p2 = CKKSEncoder.sigma_inverse(vectorB);
        System.out.println("p2: " + p2);

        Complex[] decode1 = CKKSEncoder.sigma(p1);
        Complex[] decode2 = CKKSEncoder.sigma(p2);

        System.out.println("Decode vector A: ");
        for(int i = 0; i < N; i++) {
            System.out.println("Element " + (i + 1) + ": " + decode1[i]);
        }

        System.out.println("Decode vector B: ");
        for(int i = 0; i < N; i++) {
            System.out.println("Element " + (i + 1) + ": " + decode2[i]);
        }

        // System.out.println("What Operation? (1: Addition, 2: Multiplication)");
        // int operation = Input.nextInt();
        // while(operation != 1 && operation != 2) {
        //     System.out.println("What Operation? (1: Addition, 2: Multiplication)");
        //     operation = Input.nextInt();
        // }
        // if (operation == 1) {
        //     Polynomial p3 = p1.add(p2);
        //     System.out.println("p3: " + p3);
        // } else {
        //     Polynomial p3 = p1.multiply(p2);
        //     System.out.println("p3: " + p3);
        // }
    }
}