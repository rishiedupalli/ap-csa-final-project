public class ComplexNumber {
    double x = 0;
    double y = 0;

    public ComplexNumber() {
        this.x = 0;
        this.y = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.x = real;
        this.y = imaginary;
    }

    public PolarComplexNumber toPolar() {
        return new PolarComplexNumber(Math.sqrt(x * x + y * y), Math.atan(y / x));
    }

    @Override
    public String toString() {
        return x + " + i" + y;
    }
}

class PolarComplexNumber extends ComplexNumber {
    double r = 0;
    double theta = 0;

    public PolarComplexNumber() {
        this.r = 0;
        this.theta = 0;
    }

    public PolarComplexNumber(double magnitude, double angle) {
        super(magnitude * Math.cos(angle), magnitude * Math.sin(angle));
        this.r = magnitude;
        this.theta = angle;
    }

    public ComplexNumber toCartesian() {
        return new ComplexNumber(r * Math.cos(theta), r * Math.sin(theta));
    }

    public ComplexNumber[] yieldNthRootsOfUnity(int n) {
        ComplexNumber[] roots = new ComplexNumber[n];
        for (int i = 0; i < n; i++) {
            roots[i] = new ComplexNumber(Math.cos(2 * Math.PI * i / n), Math.sin(2 * Math.PI * i / n));
        }
        return roots;
    }

    public ComplexNumber yieldNthRootOfUnity(int n) {
        return new ComplexNumber(Math.cos(2 * Math.PI / n), Math.sin(2 * Math.PI / n));
    }

    @Override
    public String toString() {
        return r + "e^(i" + theta + ")";
    }
}