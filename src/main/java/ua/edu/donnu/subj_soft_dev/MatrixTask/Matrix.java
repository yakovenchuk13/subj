package ua.edu.donnu.subj_soft_dev.MatrixTask;

import ua.edu.donnu.subj_soft_dev.VectorSecondTask.TypeNumber;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Matrix<E> implements Cloneable {

    private static final Scanner sc = new Scanner(System.in);
    // default size
    private static final int INITIAL_CAPACITY = 5;
    private E[][] matrix;

    public Matrix(){
        this.matrix = (E[][])new Object[INITIAL_CAPACITY][INITIAL_CAPACITY];
        return;
    }

    public Matrix(int row, int column){
        if((row <= 0) || (column <= 0)){
            throw new IllegalArgumentException("Incorrect size!");
        }

        this.matrix = (E[][])new Object[row][column];
        return;
    }

    public Matrix(E[][] matrix){
        if(Objects.isNull(matrix)){
            throw new IllegalArgumentException("Incorrect size!");
        }

        this.matrix = copyMatrix(matrix);
        return;
    }

    public int getCountRow(){
        return this.matrix.length;
    }

    public int getCountColumn(){
        return this.matrix[0].length;
    }

    public E getValue(int row, int column){
        boolean isCorrectSize = isCorrectDimensionValue(row, column);
        if(!isCorrectSize){
            throw new IllegalArgumentException("Incorrect size!");
        }

        return this.matrix[row][column];
    }

    public int setCountRow(int row){
        if(row <= 0){
            throw new IllegalArgumentException("Incorrect size!");
        }

        this.matrix = copyMatrix(this.matrix, row, this.matrix[0].length);
        return 0;
    }

    public int setCountColumn(int column){
        if(column <= 0){
            throw new IllegalArgumentException("Incorrect size!");
        }

        this.matrix = copyMatrix(this.matrix, this.matrix.length, column);
        return 0;
    }

    public int setValue(int row, int column, E value){
        boolean isCorrectSize = isCorrectDimensionValue(row, column);
        if(!isCorrectSize){
            throw new IllegalArgumentException("Incorrect size!");
        }

        this.matrix[row][column] = value;

        return 0;
    }

    public int setMatrix(E[][] matrix){
        if(Objects.isNull(matrix)){
            throw new IllegalArgumentException("Incorrect size!");
        }

        this.matrix = copyMatrix(matrix);
        return 0;
    }

    public Matrix<E> add(Matrix<E> m){
        boolean isEqualsSize = checkEqualsSizeMatrix(this, m);
        if(!isEqualsSize){
            throw new IllegalArgumentException("Incorrect size!");
        }

        Matrix<E> answer = new Matrix<>(this.matrix);
        E sum;
        for (int i = 0; i < answer.getCountRow(); i++) {
            for (int j = 0; j < answer.getCountColumn(); j++) {
                sum = addNumbers(m.getValue(i,j), answer.getValue(i,j));
                answer.setValue(i,j,sum);
            }
        }

        return answer;
    }

    public Matrix<E> add(E number){
        if(Objects.isNull(number)){
            throw new IllegalArgumentException("Incorrect number!");
        }

        Matrix<E> answer = new Matrix<>(this.matrix);
        E sum;
        for (int i = 0; i < answer.getCountRow(); i++) {
            for (int j = 0; j < answer.getCountColumn(); j++) {
                sum = addNumbers(answer.getValue(i,j), number);
                answer.setValue(i,j,sum);
            }
        }

        return answer;
    }

    public Matrix<E> subtract(Matrix<E> m){
        boolean isEqualsSize = checkEqualsSizeMatrix(this, m);
        if(!isEqualsSize){
            throw new IllegalArgumentException("Incorrect size!");
        }

        Matrix<E> answer = new Matrix<>(this.matrix);
        E sum;
        for (int i = 0; i < answer.getCountRow(); i++) {
            for (int j = 0; j < answer.getCountColumn(); j++) {
                sum = subtractNumbers(answer.getValue(i,j), m.getValue(i,j));
                answer.setValue(i,j,sum);
            }
        }

        return answer;
    }

    public Matrix<E> subtract(E number){
        if(Objects.isNull(number)){
            throw new IllegalArgumentException("Incorrect number!");
        }

        Matrix<E> answer = new Matrix<>(this.matrix);
        E sum;
        for (int i = 0; i < answer.getCountRow(); i++) {
            for (int j = 0; j < answer.getCountColumn(); j++) {
                sum = subtractNumbers(answer.getValue(i,j), number);
                answer.setValue(i,j,sum);
            }
        }

        return answer;
    }

    public Matrix<E> multiply(Matrix<E> m){
        boolean isEqualsSize = checkEqualsSizeMatrix(this, m);
        if(!isEqualsSize){
            throw new IllegalArgumentException("Incorrect size!");
        }

        int countRowFirstMatrix = this.getCountRow();
        int countColumnSecondMatrix = m.getCountColumn();
        int countRowSecondtMatrix = m.getCountRow();

        Matrix<E> answer = new Matrix<>(countRowFirstMatrix, countColumnSecondMatrix);

        for (int i = 0; i < countRowFirstMatrix; i++) {
            for (int j = 0; j < countColumnSecondMatrix; j++) {
                for (int k = 0; k < countRowSecondtMatrix; k++) {
                    E sum = multiplyNumbers(this.getValue(i,k), m.getValue(k,j));
                    E currentValue = answer.getValue(i,j);
                    if(Objects.nonNull(currentValue)){
                        sum = addNumbers(sum,currentValue);
                    }
                    answer.setValue(i,j,sum);
                }
            }
        }

        return answer;
    }

    public Matrix<E> multiply(E number){
        if(Objects.isNull(number)){
            throw new IllegalArgumentException("Incorrect number!");
        }

        Matrix<E> answer = new Matrix<>(this.matrix);
        E sum;
        for (int i = 0; i < answer.getCountRow(); i++) {
            for (int j = 0; j < answer.getCountColumn(); j++) {
                sum = multiplyNumbers(answer.getValue(i,j), number);
                answer.setValue(i,j,sum);
            }
        }

        return answer;
    }

    public Matrix<E> divide(E number){
        if(Objects.isNull(number)){
            throw new IllegalArgumentException("Incorrect number!");
        }

        Matrix<E> answer = new Matrix<>(this.matrix);
        E sum;
        for (int i = 0; i < answer.getCountRow(); i++) {
            for (int j = 0; j < answer.getCountColumn(); j++) {
                sum = divideNumbers(answer.getValue(i,j), number);
                answer.setValue(i,j,sum);
            }
        }

        return answer;
    }

    public Matrix<E> readFromConsole(TypeNumber typeNumber){
        int row = -1, column = -1;

        while (row < 0 && column < 0){
            System.out.print("Enter correct count row: ");
            String strRow = sc.next();
            System.out.print("Enter correct count column: ");
            String strColumn = sc.next();
            System.out.println();
            try {
                row = Integer.parseInt(strRow);
                column = Integer.parseInt(strColumn);
            } catch (NumberFormatException nfe){
                System.out.println("Error number. Enter again!");
            }
        }

        Matrix m = createMatrix(row, column, typeNumber);

        int i = 0, j = 0;

        while(i != m.getCountRow()){
            while(i != m.getCountRow()){
                System.out.print("Enter number[" + i + "][" + j + "] = ");
                String str = sc.next();
                System.out.println();
                try {
                    m.setValue(i,j, parse(str, typeNumber));
                    j++;
                } catch (NumberFormatException nfe){
                    System.out.println("Error number. Enter again!");
                }
            }
            i++;
        }

        return m;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return Arrays.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(matrix);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Arrays.stream(this.matrix).forEach(m -> s.append(Arrays.toString(m)+"\n"));
        return s.toString();
    }

    private E[][] copyMatrix(E[][] matrix, int row, int length) {
        E[][] where = (E[][])new Object[row][];

        for (int i = 0; i < matrix.length; i++) {
            where[i] = Arrays.copyOf(matrix[i], length);
        }

        return where;
    }

    private E[][] copyMatrix(E[][] original) {
        E[][] where = (E[][])new Object[original.length][];

        for (int i = 0; i < original.length; i++) {
            where[i] = Arrays.copyOf(original[i], original[i].length);
        }

        return where;
    }

    private boolean checkEqualsSizeMatrix(Matrix<E> m1, Matrix<E> m2) {
        if((m1.getCountColumn() == m2.getCountColumn()) && (m1.getCountRow() == m2.getCountRow())){
            return true;
        }

        return false;
    }

    private boolean isCorrectDimensionValue(int row, int column) {
        if(row < 0 || column < 0 || row >= matrix.length || column >= matrix[0].length){
            return false;
        }

        return true;
    }

    private Matrix createMatrix(int row, int column, TypeNumber typeNumber) {
        if(typeNumber.equals(TypeNumber.DOUBLE)) {
            return new Matrix<Double>(row,column);
        } else if(typeNumber.equals(TypeNumber.FLOAT)) {
            return new Matrix<Float>(row,column);
        } else if(typeNumber.equals(TypeNumber.LONG)) {
            return new Matrix<Long>(row,column);
        } else if(typeNumber.equals(TypeNumber.INTEGER)) {
            return new Matrix<Integer>(row,column);
        }

        throw  new NumberFormatException();
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
