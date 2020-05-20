package ua.edu.donnu.subj_soft_dev.VectorSecondTask;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class VectorTest {

    @Test
    public void getSize() {
        Vector<Integer> v = new Vector<>();

        System.out.println(v);

        assertEquals(10, v.getSize());
    }

    @Test
    public void setSize() {
        Vector<Integer> v = new Vector<>();

        System.out.println(v);

        v.insert(1);

        System.out.println(v);

        v.setSize(20);

        System.out.println(v);

       assertEquals(20, v.getSize());
    }

    @Test
    public void setArr() {
        Integer[] i = {1,2,3,4,5};

        System.out.println(Arrays.toString(i));

        Vector<Integer> v = new Vector<>();

        v.setArr(i);

        System.out.println(v);

        assertEquals(i.length, v.getSize());
    }

    @Test
    public void insert() {
        Vector<Integer> v = new Vector<>();

        System.out.println(v);

        Integer i = 1;

        v.insert(i);

        System.out.println(v);

        assertTrue(i.equals(v.get(0)));
    }

    @Test
    public void add() {
        Integer[] i = {1,2,3,4,5};
        Integer[] i2 = {6,7,8,9,10};

        Vector<Integer> v1 = new Vector<>(i);
        System.out.println(v1 + "\n\t+");
        Vector<Integer> v2 = new Vector<>(i2);
        System.out.println(v2 + "\n\t=");

        Vector<Integer> v3 = v1.add(v2);
        System.out.println(v3);

        boolean isCorrect = true;

        int v1Size = v1.getSize();

        for(int j = 0; j < v1Size; j++){
            if(v3.get(j) != v1.get(j) + v2.get(j)){
                isCorrect = false;
            }
        }

        assertTrue(isCorrect);
    }

    @Test
    public void add1() throws CloneNotSupportedException {
        Integer[] i = {1,2,3,4,5};

        System.out.println(Arrays.toString(i));

        Vector<Integer> v1 = new Vector<>(i);

        System.out.println("before add: " + v1);

        Integer n = 10;

        Vector<Integer> v3 = v1.add(n);

        System.out.println("after add: " + v3);

        assertTrue(n.equals(v3.get(i.length)));
    }

    @Test
    public void substr() {
        Integer[] i = {1,2,3,4,5};
        Integer[] i2 = {6,7,8,9,10};

        Vector<Integer> v1 = new Vector<>(i);
        System.out.println(v1 + "\n\t-");
        Vector<Integer> v2 = new Vector<>(i2);
        System.out.println(v2 + "\n\t=");

        Vector<Integer> v3 = v1.subtract(v2);
        System.out.println(v3);

        boolean isCorrect = true;

        int v1Size = v1.getSize();

        for(int j = 0; j < v1Size; j++){
            if(v3.get(j) != v1.get(j) - v2.get(j)){
                isCorrect = false;
            }
        }

        assertTrue(isCorrect);
    }

    @Test
    public void mult() {
        Integer[] i = {1,2,3,4,5};
        Integer[] i2 = {6,7,8,9,10};

        Vector<Integer> v1 = new Vector<>(i);
        System.out.println(v1 + "\n\t*");
        Vector<Integer> v2 = new Vector<>(i2);
        System.out.println(v2 + "\n\t=");

        Vector<Integer> v3 = v1.multiply(v2);
        System.out.println(v3);

        boolean isCorrect = true;

        int v1Size = v1.getSize();

        for(int j = 0; j < v1Size; j++){
            if(v3.get(j) != v1.get(j) * v2.get(j)){
                isCorrect = false;
            }
        }

        assertTrue(isCorrect);
    }

    @Test
    public void mult2() {
        Integer[] i = {1,2,3,4,5};
        Integer i2 = 6;

        Vector<Integer> v1 = new Vector<>(i);
        System.out.println(v1 + "\n\t*");
        System.out.println("\t" + i2 + "\n\t=");

        Vector<Integer> v3 = v1.multiply(i2);
        System.out.println(v3);

        boolean isCorrect = true;

        int v1Size = v1.getSize();

        for(int j = 0; j < v1Size; j++){
            if(v3.get(j) != v1.get(j) * i2){
                isCorrect = false;
            }
        }

        assertTrue(isCorrect);
    }

    @Test
    public void div() {
        Integer[] i = {1,2,3,4,5};
        Integer[] i2 = {6,7,8,9,10};

        Vector<Integer> v1 = new Vector<>(i);
        System.out.println(v1 + "\n\t/");
        Vector<Integer> v2 = new Vector<>(i2);
        System.out.println(v2 + "\n\t=");

        Vector<Integer> v3 = v1.divide(v2);
        System.out.println(v3);

        boolean isCorrect = true;

        int v1Size = v1.getSize();

        for(int j = 0; j < v1Size; j++){
            if(v3.get(j) != v1.get(j) / v2.get(j)){
                isCorrect = false;
            }
        }

        assertTrue(isCorrect);
    }

    @Test
    public void get() {
        Vector<Integer> v = new Vector<>();

        Integer i = 1;

        v.insert(i);

        System.out.println(v);

        System.out.println("get element with index 0: " + v.get(0));

        assertTrue(i.equals(v.get(0)));
    }

    @Test
    public void remove() {
        Vector<Integer> v = new Vector<>();

        Integer i = 1;

        v.insert(i);

        System.out.println(v);

        v.remove(0);

        System.out.println(v);

        assertTrue(v.isEmpty());
    }

    @Test
    public void clone1() throws CloneNotSupportedException {
        Vector<Integer> v = new Vector<>();

        Integer i = 1;

        v.insert(i);

        System.out.println(v);

        Vector<Integer> v2 = v.clone();

        System.out.println(v2);

        v2.insert(5);

        System.out.println("\n" + v + "\n" + v2);

        assertFalse(v.equals(v2));
    }

    @Test
    public void equals1() throws CloneNotSupportedException {
        Vector<Integer> v = new Vector<>();

        Integer i = 1;

        v.insert(i);

        System.out.println(v);

        Vector<Integer> v2 = new Vector<>();

        Integer i2 = 1;

        v2.insert(i);

        System.out.println(v2);

        assertTrue(v.equals(v2));
    }

    @Test
    public void toString1() {
        final String result = "Vector{arr=[null, null, null, null, null, null, null, null, null, null], currentSize=0}";
        Vector<Integer> v = new Vector<>();
        System.out.println(v);

        assertTrue(result.equals(v.toString()));
    }

}
