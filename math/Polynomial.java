package math;

public class Polynomial {
    // create a polynomial class with a private array of coefficients
    private ComplexNumber[] coefficients;
    private int degree;

    public Polynomial(ComplexNumber[] coefficients) {
        this.coefficients = coefficients;
        this.degree = coefficients.length - 1;
    }

    public Polynomial(int degree) {
        this.degree = degree;
        this.coefficients = new ComplexNumber[degree + 1];
    }

    @Override
    public String toString() {
        // return the polynomial as a string in the form of "a0 + a1*x + a2*x^2 + ... + an*x^n"
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= this.degree; i++) {
            if (i == 0) {
                sb.append(this.coefficients[i]);
            } else {
                sb.append(" + " + this.coefficients[i] + "*x^" + i);
            }
        }
        return sb.toString();
    }
}