package ua.edu.donnu.subj_soft_dev.VectorSecondTask;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * This class provides custom implementation of Vector
 * Insertion order of objects is maintained.
 * Implementation allows you to store null as well.
 * @param <E>
 */
public class Vector<E> implements Cloneable {

    private static final Scanner sc = new Scanner(System.in);
    // default size
    private static final int INITIAL_CAPACITY = 10;
    private E arr[];
    private int currentSize = 0;

    /**
     * constructor.
     */
    public Vector() {
        E[] arr = (E[])new Object[INITIAL_CAPACITY];
        this.arr = arr;

        return;
    }

    public Vector(int capacity) {
        if(capacity <= 0){
            throw new IndexOutOfBoundsException("Capacity: " + capacity);
        }

        E[] arr = (E[])new Object[capacity];
        this.arr = arr;

        return;
    }

    public Vector(E[] arr){
        setArr(arr);

        return;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return arr.length;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        if (size < 0) {  //if index is negative or greater than currentSize of currentSize, we throw Exception.
            throw new IndexOutOfBoundsException("Size: " + size);
        }

        if (size >= arr.length) {
            ensureCapacity(); //increase current capacity of list, make it double.
        }

        return;
    }

    public void setArr(E[] arr) {
        if(Objects.isNull(arr)){
            throw new IndexOutOfBoundsException("New arr is null. Value not set.");
        }

        this.arr = arr;

        this.currentSize = arr.length;

        return;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    /**
     * method adds elements in Vector.
     */
    public synchronized boolean insert(E e) {
        if (currentSize == arr.length) {
            ensureCapacity(); //increase current capacity of list, make it double.
        }

        arr[currentSize++] = e;

        return true;
    }

    public Vector<E> add (E e) throws CloneNotSupportedException {
        Vector result = this.clone();

        result.insert(e);

        return result;
    }

    public Vector<E> add(Vector<E> v2){
        final int v1Size = this.currentSize;
        final int v2Size = v2.currentSize;

        E arr[] = null;

        if(v1Size == v2Size){
             arr = (E[])new Object[getSize()];

            for (int i = 0; i < v1Size; i++) {
                arr[i] = addNumbers(v2.get(i), this.get(i));
            }
        }

        return new Vector(arr);
    }

    public Vector<E> subtract(Vector<E> v2){
        final int v1Size = this.currentSize;
        final int v2Size = v2.currentSize;

        E arr[] = null;

        if(v1Size == v2Size){
            arr = (E[])new Object[getSize()];

            for (int i = 0; i < v1Size; i++) {
                arr[i] = subtractNumbers(this.get(i),v2.get(i));
            }
        }

        return new Vector(arr);
    }

    public Vector<E> multiply(Vector<E> v2){
        final int v1Size = this.currentSize;
        final int v2Size = v2.currentSize;

        E arr[] = null;

        if(v1Size == v2Size){
            arr = (E[])new Object[getSize()];

            for (int i = 0; i < v1Size; i++) {
                arr[i] = multiplyNumbers(v2.get(i), this.get(i));
            }
        }

        return new Vector(arr);
    }

    public Vector<E> multiply(E e){
        final int v1Size = this.currentSize;

        E arr[] = null;

        if(v1Size > 0){
            arr = (E[])new Object[getSize()];

            for (int i = 0; i < v1Size; i++) {
                arr[i] = multiplyNumbers(e, this.get(i));
            }
        }

        return new Vector(arr);
    }

    public Vector<E> divide(Vector<E> v2){
        final int v1Size = this.arr.length;
        final int v2Size = v2.arr.length;

        E arr[] = null;

        if(v1Size == v2Size){
            arr = (E[])new Object[v1Size];

            for (int i = 0; i < v1Size; i++) {
                arr[i] = divideNumbers(this.get(i),v2.get(i));
            }
        }

        return new Vector(arr);
    }

    /**
     * method returns element on specific index.
     */
    public E get(int index) {
        //if index is negative or greater than currentSize of currentSize, we throw Exception.
        checkIndex(index);

        return arr[index]; //return value on index.
    }


    /**
     * method returns removedElement on specific index.
     * else it throws IndexOutOfBoundException if index is negative or greater than currentSize of currentSize.
     */
    public E remove(int index) {
        //if index is negative or greater than currentSize of currentSize, we throw Exception.
        checkIndex(index);

        E removedElement = arr[index];

        for(int i = index; i < currentSize - 1; i++){
            arr[i] = arr[i+1];
        }

        arr[currentSize-1] = null;

        currentSize--;   //reduce currentSize of Vector after removal of element.

        return removedElement;
    }

    public Vector<E> remove(E e) throws CloneNotSupportedException {
        int index = -1;

        for (int i = 0; i < currentSize; i++) {
            if(get(i).equals(e)){
                index = i;
            }
        }

        Vector result = this.clone();

        result.remove(index);

        return result;
    }

    @Override
    protected Vector clone() throws CloneNotSupportedException {
        try {
            @SuppressWarnings("unchecked")
            Vector<E> v = (Vector<E>) super.clone();
            v.arr = Arrays.copyOf(this.arr, arr.length);
            v.currentSize = this.currentSize;
            return v;
        } catch (CloneNotSupportedException e) {
            // this shouldn't happen, since we are Cloneable
            throw new InternalError(e);
        }
    }

    public Vector<E> readFromConsole(TypeNumber typeNumber){
        int size = -1;

        while (size < 0){
            System.out.print("Enter correct size: ");
            String str = sc.next();
            System.out.println();
            try {
                size = Integer.parseInt(str);
            } catch (NumberFormatException nfe){
                System.out.println("Error number. Enter again!");
            }
        }

        Vector v = createVector(typeNumber, size);

        int i = 0;

        while(i != v.getSize()){
            System.out.print("Enter number[" + i + "]: ");
            String str = sc.next();
            System.out.println();
            try {
                v.insert(parse(str, typeNumber));
                i++;
            } catch (NumberFormatException nfe){
                System.out.println("Error number. Enter again!");
            }
        }

        return v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector<?> vector = (Vector<?>) o;
        return currentSize == vector.currentSize &&
                Arrays.equals(arr, vector.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(currentSize);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "arr=" + Arrays.toString(arr) +
                ", currentSize=" + currentSize +
                '}';
    }

    /**
     * method increases capacity of list by making it double.
     */
    private void ensureCapacity() {
        int newIncreasedCapacity = arr.length * 2;
        arr = Arrays.copyOf(arr, newIncreasedCapacity);
    }

    /**
     * method increases capacity of list by making it double.
     */
    private void ensureCapacity(int newSize) {
        arr = Arrays.copyOf(arr, newSize);
    }

    /**
     * method check index number on correct
     */
    private void checkIndex(int index) throws IndexOutOfBoundsException{
        if ( index < 0 || index >= currentSize) {  //if index is negative or greater than currentSize of currentSize, we throw Exception.
            throw new IndexOutOfBoundsException("Index: " + index + ", currentSize " + index);
        }
    }

    private E parse(String str, TypeNumber typeNumber) {
        if(typeNumber.equals(TypeNumber.DOUBLE)) {
            return (E)(Double)(Double.parseDouble(str));
        } else if(typeNumber.equals(TypeNumber.FLOAT)) {
            return (E)(Float)(Float.parseFloat(str));
        } else if(typeNumber.equals(TypeNumber.LONG)) {
            return (E)(Long)(Long.parseLong(str));
        } else if(typeNumber.equals(TypeNumber.INTEGER)) {
            return (E)(Integer)(Integer.parseInt(str));
        }

        throw  new NumberFormatException();
    }

    private Vector createVector(TypeNumber typeNumber, int size) {
        if(typeNumber.equals(TypeNumber.DOUBLE)) {
            return new Vector<Double>(size);
        } else if(typeNumber.equals(TypeNumber.FLOAT)) {
            return new Vector<Float>(size);
        } else if(typeNumber.equals(TypeNumber.LONG)) {
            return new Vector<Long>(size);
        } else if(typeNumber.equals(TypeNumber.INTEGER)) {
            return new Vector<Integer>(size);
        }

        throw  new NumberFormatException();
    }

    private E addNumbers(E a, E b) {
        if(a instanceof Double) {
            return (E)(Double)((Double)a + (Double)b);
        } else if(a instanceof Float) {
            return (E)(Float)((Float)a + (Float)b);
        } else if(a instanceof Long) {
            return (E)(Long)((Long)a + (Long)b);
        } else if(a instanceof Integer) {
            return (E)(Integer)((Integer)a + (Integer)b);
        }

        return (E) new Object();
    }

    private E subtractNumbers(E a, E b) {
        if(a instanceof Double) {
            return (E)(Double)((Double)a - (Double)b);
        } else if(a instanceof Float) {
            return (E)(Float)((Float)a - (Float)b);
        } else if(a instanceof Long) {
            return (E)(Long)((Long)a - (Long)b);
        } else if(a instanceof Integer) {
            return (E)(Integer)((Integer)a - (Integer)b);
        }

        return (E) new Object();
    }

    private E multiplyNumbers(E a, E b) {
        if(a instanceof Double) {
            return (E)(Double)((Double)a * (Double)b);
        } else if(a instanceof Float) {
            return (E)(Float)((Float)a * (Float)b);
        } else if(a instanceof Long) {
            return (E)(Long)((Long)a * (Long)b);
        } else if(a instanceof Integer) {
            return (E)(Integer)((Integer)a * (Integer)b);
        }

        return (E) new Object();
    }

    private E divideNumbers(E a, E b) {
        if(a instanceof Double) {
            return (E)(Double)((Double)a / (Double)b);
        } else if(a instanceof Float) {
            return (E)(Float)((Float)a / (Float)b);
        } else if(a instanceof Long) {
            return (E)(Long)((Long)a / (Long)b);
        } else if(a instanceof Integer) {
            return (E)(Integer)((Integer)a / (Integer)b);
        }

        return (E) new Object();
    }

}