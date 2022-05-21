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

    public ComplexNumber evaluate(ComplexNumber x) {
        ComplexNumber result = new ComplexNumber(0, 0);
        for (int i = 0; i <= degree; i++) {
            result = result.add(coefficients[i].multiply(x.exponentiate(i)));
        }
        return result;
    }

    @Override
    public String toString() {
        // return the polynomial as a string in the form of "a0 + a1*x + a2*x^2 + ... + an*x^n"
        String polynomial = "";
        for (int i = 0; i < coefficients.length; i++) {
            if (i == 0) {
                polynomial += coefficients[i];
            } else {
                polynomial += " + (" + coefficients[i] + ")*x^" + i;
            }
        }

        return polynomial;
    }
}