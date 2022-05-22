package math;

import org.apache.commons.math3.complex.*;
import org.apache.commons.math3.linear.*;

public class Polynomial {
    private FieldVector<Complex> Coeffs;
    private int degree;

    public Polynomial(FieldVector<Complex> Coeffs) {
        this.Coeffs = Coeffs;
        this.degree = Coeffs.getDimension() - 1;
    }

    public Complex eval(Complex x) {
        Complex result = Complex.ZERO;
        for(int i = 0; i <= degree; i++) {
            result = result.add(Coeffs.getEntry(i).multiply(x.pow(i)));
        }
        return result;
    }

    public Polynomial addPolynomial(Polynomial p) {
        int maxDegree = Math.max(degree, p.degree);
        FieldVector<Complex> newCoeffs = new ArrayFieldVector<Complex>(ComplexField.getInstance(), maxDegree + 1);
        for(int i = 0; i <= maxDegree; i++) {
            newCoeffs.setEntry(i, Coeffs.getEntry(i).add(p.Coeffs.getEntry(i)));
        }
        return new Polynomial(newCoeffs);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= degree; i++) {
            sb.append(Coeffs.getEntry(i));
            if(i != degree) {
                sb.append(" + ");
            }
        }
        return sb.toString();
    }
}
