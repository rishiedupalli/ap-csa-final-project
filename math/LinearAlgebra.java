package math;
public class LinearAlgebra {
    public static ComplexNumber[][] ConstructVandermondeMatrix(int M, int N, ComplexNumber MthRootOfUnity) {
        ComplexNumber[][] V = new ComplexNumber[N][N];

        for (int i = 0; i < N; i++) {
            ComplexNumber root = MthRootOfUnity.exponentiate((2 * i + 1));
            for (int j = 0; j < N; j++) {
                V[i][j] = root.exponentiate(j);
            }
        }
        return V;
    }

    public static ComplexNumber[] solve(int N, ComplexNumber[][] A, ComplexNumber[] b) {
        // Solve Ax = b for x where A is an N x N Matrix of Complex Numbers and b is an 1 x N vector of Complex Numbers

        // solve using LU decomposition
        ComplexNumber[] x = new ComplexNumber[N];
        ComplexNumber[] L = new ComplexNumber[N];
        ComplexNumber[] U = new ComplexNumber[N];
        ComplexNumber[] y = new ComplexNumber[N];

        for (int i = 0; i < N; i++) {
            L[i] = new ComplexNumber(1, 0);
            U[i] = new ComplexNumber(1, 0);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                ComplexNumber sum = new ComplexNumber(0, 0);
                for (int k = 0; k < j; k++) {
                    sum = sum.add(L[k].multiply(U[j - k - 1]));
                }
                L[j] = A[i][j].subtract(sum);
            }

            for (int j = i; j < N; j++) {
                ComplexNumber sum = new ComplexNumber(0, 0);
                for (int k = 0; k < i; k++) {
                    sum = sum.add(L[k].multiply(U[j - k - 1]));
                }
                U[j] = A[i][j].subtract(sum);
            }

            ComplexNumber sum = new ComplexNumber(0, 0);
            for (int k = 0; k < i; k++) {
                sum = sum.add(L[k].multiply(y[k]));
            }
            y[i] = b[i].subtract(sum);
        }

        for (int i = N - 1; i >= 0; i--) {
            ComplexNumber sum = new ComplexNumber(0, 0);
            for (int k = i + 1; k < N; k++) {
                sum = sum.add(U[k].multiply(x[k]));
            }
            x[i] = (y[i].subtract(sum)).divide(U[i]);
        }
        return x;
    }
}