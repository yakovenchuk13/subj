package ua.edu.donnu.subj_soft_dev.ComplexNumFirstTask;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexTest {

    @Test
    public void add() {
        Complex c1 = new Complex(1.0d,3.0d);
        Complex c2 = new Complex(1.0d,-2.0d);

        Complex c3 = c1.add(c2);

        System.out.println(c1 + " + " + c2 + " = " + c3);

        assertEquals(c3,new Complex(2.0d, 1.0d));
    }

    @Test
    public void add1() {
        Complex c1 = new Complex(1.0d,3.0d);
        double d = 5.0d;

        Complex c2 = c1.add(d);

        System.out.println(c1 + " + " + d + " = " + c2);

        assertEquals(c2, new Complex(6.0d,3.0d));
    }

    @Test
    public void add2() {
        Complex c1 = new Complex(1.0d,3.0d);
        int d = 5;

        Complex c2 = c1.add(d);

        System.out.println(c1 + " + " + d + " = " + c2);

        assertEquals(c2, new Complex(6.0d,3.0d));
    }

    @Test
    public void add3() {
        Complex c1 = new Complex(1.0d,3.0d);
        long d = 5;

        Complex c2 = c1.add(d);

        System.out.println(c1 + " + " + d + " = " + c2);

        assertEquals(c2, new Complex(6.0d,3.0d));
    }

    @Test
    public void subtract() {
        Complex c1 = new Complex(1.0d,3.0d);
        Complex c2 = new Complex(2.0d,2.0d);

        Complex c3 = c1.subtract(c2);

        System.out.println(c1 + " - " + c2 + " = " + c3);

        assertEquals(c3, new Complex(-1.0d,1.0d));
    }

    @Test
    public void subtract1() {
        Complex c1 = new Complex(1.0d,3.0d);
        double d = 5.0d;

        Complex c2 = c1.subtract(d);

        System.out.println(c1 + " - " + d + " = " + c2);

        assertEquals(c2, new Complex(-4.0d,3.0d));
    }

    @Test
    public void subtract2() {
        Complex c1 = new Complex(1.0d,3.0d);
        int d = 5;

        Complex c2 = c1.subtract(d);

        System.out.println(c1 + " - " + d + " = " + c2);

        assertEquals(c2, new Complex(-4.0d,3.0d));
    }

    @Test
    public void subtract3() {
        Complex c1 = new Complex(1.0d,3.0d);
        long d = 5L;

        Complex c2 = c1.subtract(d);

        System.out.println(c1 + " - " + d + " = " + c2);

        assertEquals(c2, new Complex(-4.0d,3.0d));
    }

    @Test
    public void multiply() {
        Complex c1 = new Complex(1.0d,3.0d);
        Complex c2 = new Complex(2.0d,2.0d);

        Complex c3 = c1.multiply(c2);

        System.out.println(c1 + " * " + c2 + " = " + c3);

        assertEquals(c3, new Complex(-4.0d,8.0d));
    }

    @Test
    public void multiply1() {
        Complex c1 = new Complex(1.0d,3.0d);
        double d = 5.0d;

        Complex c2 = c1.multiply(d);

        System.out.println(c1 + " * " + d + " = " + c2);

        assertEquals(c2, new Complex(5.0d,15.0d));
    }

    @Test
    public void multiply2() {
        Complex c1 = new Complex(1.0d,3.0d);
        int d = 5;

        Complex c2 = c1.multiply(d);

        System.out.println(c1 + " * " + d + " = " + c2);

        assertEquals(c2, new Complex(5.0d,15.0d));
    }

    @Test
    public void multiply3() {
        Complex c1 = new Complex(1.0d,3.0d);
        long d = 5L;

        Complex c2 = c1.multiply(d);

        System.out.println(c1 + " * " + d + " = " + c2);

        assertEquals(c2, new Complex(5.0d,15.0d));
    }

    @Test
    public void divide() {
        Complex c1 = new Complex(1.0d,3.0d);
        Complex c2 = new Complex(2.0d,2.0d);

        Complex c3 = c1.divide(c2);

        System.out.println(c1 + " / " + c2 + " = " + c3);

        assertEquals(c3, new Complex(1.0d,0.5d));
    }

    @Test
    public void equalstest() {
        Complex c1 = new Complex(1.0d,3.0d);

        assertTrue(c1.equals(c1));
    }

    @Test
    public void equals1() {
        Complex c1 = new Complex(1.0d,3.0d);
        Complex c2 = new Complex(1.0d,3.0d);

        assertTrue(c1.equals(c2));
    }

    @Test
    public void hashCode1() {
        Complex c1 = new Complex(1.0d,3.0d);
        Complex c2 = new Complex(1.0d,3.0d);

        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    public void toString1() {
        final String str = "real=1.0, imag=3.0";

        Complex c1 = new Complex(1.0d,3.0d);

        assertEquals(str,c1.toString());

    }
}
