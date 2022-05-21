package math;

public class PolarComplexNumber {
    private double r;
    private double theta;

    public PolarComplexNumber() {
        r = 0;
        theta = 0;
    }

    public PolarComplexNumber(double r, double theta) {
        this.r = r;
        this.theta = theta;
    }

    public ComplexNumber getNthRootOfUnity(int N) {
        return new ComplexNumber(Math.cos(2 * Math.PI / N), Math.sin(2 * Math.PI / N));
    }

    public double getModulus() {
        return r;
    }

    public double getTheta() {
        return theta;
    }

    public ComplexNumber toCartesian() {
        return new ComplexNumber(r * Math.cos(theta), r * Math.sin(theta));
    }

    @Override
    public String toString() {
        if(theta == 0) {
            return r + "";
        } else if(theta == Math.PI / 2) {
            return "j";
        } else if(theta == Math.PI) {
            return (-r) + "";
        } else if(theta == 3 * Math.PI / 2) {
            return (-r) + "j";
        } else if(theta == Math.PI / 4) {
            return r + " + j";
        } else if(theta == 3 * Math.PI / 4) {
            return r + " - j";
        } else if(theta == -Math.PI / 4) {
            return (-r) + " + j";
        } else if(theta == -3 * Math.PI / 4) {
            return (-r) + " - j";
        } else {
            return r + "e^" + theta + "j";
        }
    }
}