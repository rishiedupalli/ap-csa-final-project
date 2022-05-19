public class ComplexNumber {
    private double x;
    private double y;

    public ComplexNumber(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double yieldReal() {
        return x;
    }

    public double yieldImaginary() {
        return y;
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(x + other.x, y + other.y);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(x - other.x, y - other.y);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(x * other.x - y * other.y, x * other.y + y * other.x);
    }

    public ComplexNumber divide(ComplexNumber other) {
        return new ComplexNumber((x * other.x + y * other.y) / (other.x * other.x + other.y * other.y), (y * other.x - x * other.y) / (other.x * other.x + other.y * other.y));
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(x, -y);
    }

    public double power(int n) {
        return Math.pow(Math.sqrt(x * x + y * y), n);
    }

    public double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        return Math.atan2(y, x);
    }

    public PolarComplexNumber toPolar() {
        return new PolarComplexNumber(magnitude(), theta());
    }

    @Override
    public String toString() {
        return "(" + x + " + " + y + "i)";
    }
}

class PolarComplexNumber extends ComplexNumber {
    private double r;
    private double theta;

    public PolarComplexNumber(double r, double theta) {
        super(r * Math.cos(theta), r * Math.sin(theta));
        this.r = r;
        this.theta = theta;
    }


    
}