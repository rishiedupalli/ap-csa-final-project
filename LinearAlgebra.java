public class LinearAlgebra {
    public static ComplexNumber[][] ConstructVandermondeMatrix(int M, ComplexNumber MthRoot, ComplexNumber[] plaintext) {
        ComplexNumber[][] vandermondeMatrix = new ComplexNumber[M / 2][M / 2];
        
        for (int i = 0; i < M / 2; i++) {
            ComplexNumber Root = MthRoot.pow(2 * i + 1);
            for (int j = 0; j < M / 2; j++) {
                vandermondeMatrix[i][j] = Root.pow(new ComplexNumber(Math.cos(Math.PI/2), Math.sin(Math.PI/2)));
            }
        }

        return vandermondeMatrix;
    }

    public static ComplexNumber[] Solve(ComplexNumber[][] A, ComplexNumber[] b) {
        ComplexNumber[] Coefficients = new ComplexNumber[b.length];
        return Coefficients;
    }
}