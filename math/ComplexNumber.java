package math;

public class ComplexNumber {
    private double x; // real part of a complex number x + iy
    private double y; // imaginary part of a complex number x + iy

    public ComplexNumber() {
        this.x = 0;
        this.y = 0;
    }

    public ComplexNumber(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setReal(double x) {
        this.x = x;
    }

    public void setImaginary(double y) {
        this.y = y;
    }

    public double getReal() {
        return x;
    }

    public double getImaginary() {
        return y;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.x + other.getReal() , this.y + other.getImaginary());
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(this.x - other.getReal() , this.y - other.getImaginary());
    }

    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(this.x * other.getReal() - this.y * other.getImaginary() , this.x * other.getImaginary() + this.y * other.getReal());
    }

    public ComplexNumber divide(ComplexNumber other) {
        return new ComplexNumber((this.x * other.getReal() + this.y * other.getImaginary()) / (other.getReal() * other.getReal() + other.getImaginary() * other.getImaginary()) , (this.y * other.getReal() - this.x * other.getImaginary()) / (other.getReal() * other.getReal() + other.getImaginary() * other.getImaginary()));
    }

    public double getModulus() {
        return Math.sqrt(x * x + y * y);
    }

    public double getTheta() {
        return Math.atan(y/x);
    }

    public PolarComplexNumber toPolar() {
        return new PolarComplexNumber(getModulus(), getTheta());
    }

    public ComplexNumber exponentiate(ComplexNumber exponent) {
        double c = exponent.getReal();
        double d = exponent.getImaginary();
        return new ComplexNumber(Math.pow(getModulus(), c/2) * Math.exp(-d * getTheta()) * Math.cos((c * getTheta()) + .5 * d * Math.log(getModulus())),
        Math.pow(getModulus(), c/2) * Math.exp(-d * getTheta()) * Math.sin((c * getTheta()) + .5 * d * Math.log(getModulus())));  
    }

    @Override
    public String toString() {
        if(y == 0) {
            return x + "";
        } else if(x == 0) {
            return y + "j";
        } else if(y < 0) {
            return x + " - " + (-y) + "j";
        } else {
            return x + " + " + y + "j";
        }
    }
}