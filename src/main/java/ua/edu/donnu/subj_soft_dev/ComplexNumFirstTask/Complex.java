package ua.edu.donnu.subj_soft_dev.ComplexNumFirstTask;

import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * Complex number class.
 *
 * A Complex consists of a real and imaginary
 * part of type double
 *
 */
public class Complex implements Serializable {

    // for read from console
    private static final Scanner sc = new Scanner(System.in);
    // if imag = 0
    public static final double ZERO = 0.0d;

    private double real;
    private double imag;

    /**
     * @param real - real part of complex number
     */
    public Complex(double real)
    {
        this(real, ZERO);
    }

    /**
     * @param real - real part of complex number
     * @param imag - imaginary part of complex number
     */
    public Complex(double real, double imag)
    {
        this.real = real;
        this.imag = imag;
    }

    /**
     * @return real part of complex number
     */
    public double getReal() {
        return real;
    }

    /**
     * @param real real part of complex number
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * @return imaginary part of complex number
     */
    public double getImag() {
        return imag;
    }

    /**
     * @param imag - imaginary part of complex number
     */
    public void setImag(double imag) {
        this.imag = imag;
    }

    /**
     * @param z - complex number to add
     * @return result of adding
     */
    public Complex add(Complex z)
    {
        return new Complex(this.real + z.getReal(), this.imag + z.getImag());
    }

    /**
     * @param z - double to add
     * @return result of adding
     */
    public Complex add(double z)
    {
        return new Complex(this.real + z, this.imag);
    }

    /**
     * @param z - int to add
     * @return result of adding
     */
    public Complex add(int z)
    {
        return new Complex(this.real + z, this.imag);
    }

    /**
     * @param z - long to add
     * @return result of adding
     */
    public Complex add(long z)
    {
        return new Complex(this.real + z, this.imag);
    }

    /**
     * @param z - complex number to subtract
     * @return result of subtract
     */
    public Complex subtract(Complex z)
    {
        return new Complex(this.real - z.getReal(), this.imag - z.getImag());
    }

    /**
     * @param z - int number to subtract
     * @return result of subtract
     */
    public Complex subtract(int z)
    {
        return new Complex(this.real - z, this.imag);
    }

    /**
     * @param z - long number to subtract
     * @return result of subtract
     */
    public Complex subtract(long z)
    {
        return new Complex(this.real - z, this.imag);
    }

    /**
     * @param z - double number to subtract
     * @return result of subtract
     */
    public Complex subtract(double z)
    {
        return new Complex(this.real - z, this.imag);
    }

    /**
     * @param z - complex number to multiply
     * @return - result of multiply
     */
    public Complex multiply(Complex z)
    {
        if (this.imag == 0d || z.getImag() == 0d)
        {
            return new Complex(this.real*z.getReal());
        }

        return new Complex((this.real*z.getReal()) - (this.imag* z.getImag()),
                          (this.real*z.getImag()) + (this.imag* z.getReal()));
    }

    /**
     * @param z - int number to multiply
     * @return - result of multiply
     */
    public Complex multiply(int z)
    {
        return new Complex(this.real*z, this.imag*z);
    }

    /**
     * @param z - long number to multiply
     * @return - result of multiply
     */
    public Complex multiply(long z)
    {
        return new Complex(this.real*z, this.imag*z);
    }

    /**
     * @param z - double number to multiply
     * @return - result of multiply
     */
    public Complex multiply(double z)
    {
        return new Complex(this.real*z, this.imag*z);
    }

    /**
     * Divide two complex numbers
     * @param z - the complex denominator/divisor
     * @return - result of divide
     */
    public Complex divide(Complex z)
    {
        double c = z.getReal();
        double d = z.getImag();

        // check for Re,Im(z) == 0 to avoid +/-infinity in result
        double zreal2 = 0.0;
        if (c != 0.0)
        {
            zreal2 = StrictMath.pow(c, 2d);
        }
        double zimag2 = 0.0;
        if (d != 0.0)
        {
            zimag2 = StrictMath.pow(d, 2d);
        }

        double ac = this.real*c;
        double bd = this.imag*d;
        double bc = this.imag*c;
        double ad = this.real*d;

        return new Complex((ac+bd)/(zreal2+zimag2),(bc-ad)/(zreal2+zimag2));
    }

    /**
     * method for entering a complex number from the console
     * @return new Complex number
     */
    public Complex readFromConsole(){
        double real = sc.nextDouble();
        double imag = sc.nextDouble();

        return new Complex(real, imag);
    }

    /**
     * @param o - object for comparison
     * @return result of comparison
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Complex complex = (Complex) o;

        return Double.compare(complex.real, real) == 0 &&
                Double.compare(complex.imag, imag) == 0;
    }

    /**
     * @return hashCode obj
     */
    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }

    /**
     * @return String - data this obj
     */
    @Override
    public String toString() {
        return "real=" + real +
                ", imag=" + imag;
    }
}
