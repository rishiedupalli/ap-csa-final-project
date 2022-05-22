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
