public class ComplexNumber {
    private double x = 0;
    private double y = 0;

    public ComplexNumber() {
        this.x = 0;
        this.y = 0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.x = real;
        this.y = imaginary;
    }

    public double getReal() {
        return this.x;
    }

    public double getImaginary() {
        return this.y;
    }

    public void setReal(double real) {
        this.x = real;
    }

    public void setImaginary(double imaginary) {
        this.y = imaginary;
    }

    public double getModulus() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public ComplexNumber pow(double n) {
        return new ComplexNumber(Math.pow(getModulus(), n) * ( Math.cos(n * Math.atan(y/x))), Math.pow(getModulus(), n) * (Math.sin(n * Math.atan(y/x))));
    }

    public ComplexNumber pow(ComplexNumber n) {
        return new ComplexNumber(Math.pow(getModulus(), n.getReal()) * ( Math.cos(n.getImaginary() * Math.atan(y/x))), Math.pow(getModulus(), n.getImaginary()) * (Math.sin(n.getImaginary() * Math.atan(y/x))));
    }

    public PolarComplexNumber toPolar() {
        return new PolarComplexNumber(Math.sqrt(x * x + y * y), Math.atan(y / x));
    }

    @Override
    public String toString() {
        if (y == 0) {
            return "[" + x + "]";
        } else if (x == 0) {
            return "[" + y + "j" + "]";
        } else if (y < 0) {
            return "[" + x + " - " + (-y) + "j" + "]";
        } else {
            return "[" + x + " + " + y + "j" + "]";
        }
    }
}

class PolarComplexNumber extends ComplexNumber {
    private double r = 0;
    private double theta = 0;

    public PolarComplexNumber() {
        this.r = 0;
        this.theta = 0;
    }

    public double getModulus() {
        return this.r;
    }

    public double getTheta() {
        return this.theta;
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
        return r + "e^(j" + theta + ")";
    }
}