public class Polynomial {
    public ComplexNumber[] coeffs;

    public Polynomial(ComplexNumber[] coeffs) {
        this.coeffs = coeffs;
    }

    public ComplexNumber evaluate(ComplexNumber z) {
        ComplexNumber result = new ComplexNumber(0, 0);
        for (int i = 0; i < coeffs.length; i++) {
            result = result.add(coeffs[i].multiply(z.pow(i)));
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < coeffs.length; i++) {
            if (coeffs[i].getReal() != 0) {
                sb.append(coeffs[i].getReal());
            }
            if (coeffs[i].getImaginary() != 0) {
                sb.append(" + " + coeffs[i].getImaginary() + "j");
            }
            if (i != coeffs.length - 1) {
                sb.append("x^" + (coeffs.length - 1 - i) + " + ");
            }
        }
        return sb.toString();
    }
}
