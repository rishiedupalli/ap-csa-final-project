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
        // print out in form z0 + z1x + z2x^2 + ... + znx^n
        String result = "";
        for(int i = 0; i <= degree; i++) {
            if(degree == 0) {
                result += Coeffs.getEntry(i);
            } else {
                if(i == 0) {
                    result += "(" +Coeffs.getEntry(i) + ")";
                } else {
                    if(Coeffs.getEntry(i).getReal() >= 0) {
                        result += "+" + "(" + Coeffs.getEntry(i) + ")" + "x^" + i;
                    } else {
                        result += "-" + "(" + Coeffs.getEntry(i).abs() + ")" + "x^" + i;
                    }
                }
            }
        }

        return result;
    }
}
