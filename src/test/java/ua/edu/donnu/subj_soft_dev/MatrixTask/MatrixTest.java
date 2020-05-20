package ua.edu.donnu.subj_soft_dev.MatrixTask;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    private static final int INITIAL_CAPACITY = 5;

    @Test
    public void testCreate(){
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix = new Matrix<>(mtrx);

        assertEquals(matrix.getCountRow(), mtrx.length);
        assertEquals(matrix.getCountColumn(), mtrx[0].length);
    }

    @Test
    public void getCountRow() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix = new Matrix<>(mtrx);
        Matrix<Integer> matrix2 = new Matrix<>();
        Matrix<Integer> matrix3 = new Matrix<>(3,4);

        assertEquals(matrix.getCountRow(), mtrx.length);
        assertEquals(matrix2.getCountRow(), INITIAL_CAPACITY);
        assertEquals(matrix3.getCountRow(), 3);
    }

    @Test
    public void getCountColumn() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix = new Matrix<>(mtrx);
        Matrix<Integer> matrix2 = new Matrix<>();
        Matrix<Integer> matrix3 = new Matrix<>(4,3);

        assertEquals(matrix.getCountColumn(), mtrx[0].length);
        assertEquals(matrix2.getCountColumn(), INITIAL_CAPACITY);
        assertEquals(matrix3.getCountColumn(), 3);
    }

    @Test
    public void getValue() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix = new Matrix<>(mtrx);

        assertEquals(matrix.getValue(0,0), mtrx[0][0]);
        assertEquals(matrix.getValue(1,1), mtrx[1][1]);
    }

    @Test
    public void setCountRow() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        final  int newSize = 5;

        Matrix<Integer> matrix = new Matrix<>(mtrx);
        matrix.setCountRow(newSize);

        assertEquals(newSize, matrix.getCountRow());
    }

    @Test
    public void setCountColumn() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        final  int newSize = 5;

        Matrix<Integer> matrix = new Matrix<>(mtrx);
        matrix.setCountColumn(newSize);

        assertEquals(newSize, matrix.getCountColumn());
    }

    @Test
    public void setValue() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix = new Matrix<>(mtrx);
        assertEquals(mtrx[1][1], matrix.getValue(1,1));

        matrix.setValue(1,1,10);
        assertNotEquals(mtrx[1][1], matrix.getValue(1,1));
        assertEquals(new Integer(10), matrix.getValue(1,1));
    }

    @Test
    public void setMatrix() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> newMatrix = new Matrix<>();
        assertEquals(INITIAL_CAPACITY, newMatrix.getCountColumn());

        newMatrix.setMatrix(mtrx);

        assertEquals(newMatrix.getValue(0,0), mtrx[0][0]);
        assertEquals(newMatrix.getValue(1,1), mtrx[1][1]);
        assertEquals(newMatrix.getCountRow(), mtrx.length);
        assertEquals(newMatrix.getCountColumn(), mtrx[0].length);
    }

    @Test
    public void add() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Integer[][] mtrx1 = new Integer[2][2];
        mtrx1[0][0] = 10;
        mtrx1[0][1] = 20;
        mtrx1[1][0] = 40;
        mtrx1[1][1] = 50;

        Matrix<Integer> matrix1 = new Matrix<>(mtrx);
        System.out.println(matrix1 + "  +");
        Matrix<Integer> matrix2 = new Matrix<>(mtrx1);
        System.out.println(matrix2 + "  =");

        Matrix<Integer> matrixRes = matrix1.add(matrix2);
        System.out.println(matrixRes);
        //assertEquals(new Integer(2), matrixRes.getValue(0,0));
        //assertEquals(new Integer(4), matrixRes.getValue(0,1));
    }

    @Test
    public void add1() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix1 = new Matrix<>(mtrx);
        System.out.println(matrix1 + "  +");
        Integer i = new Integer(10);
        System.out.println("  " + i + "\n  =");

        Matrix<Integer> matrixRes = matrix1.add(i);
        System.out.println(matrixRes);
        assertEquals(new Integer(11), matrixRes.getValue(0,0));
        assertEquals(new Integer(12), matrixRes.getValue(0,1));
    }

    @Test
    public void subtract() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix1 = new Matrix<>(mtrx);
        System.out.println(matrix1 + "  -");
        Matrix<Integer> matrix2 = new Matrix<>(mtrx);
        System.out.println(matrix2 + "  =");

        Matrix<Integer> matrixRes = matrix1.subtract(matrix2);
        System.out.println(matrixRes);
        assertEquals(new Integer(0), matrixRes.getValue(0,0));
        assertEquals(new Integer(0), matrixRes.getValue(0,1));
    }

    @Test
    public void subtract1() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix1 = new Matrix<>(mtrx);
        System.out.println(matrix1 + "  -");
        Integer i = new Integer(10);
        System.out.println("  " + i + "\n  =");

        Matrix<Integer> matrixRes = matrix1.subtract(i);
        System.out.println(matrixRes);
        assertEquals(new Integer(-9), matrixRes.getValue(0,0));
        assertEquals(new Integer(-8), matrixRes.getValue(0,1));
    }

    @Test
    public void multiply() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix1 = new Matrix<>(mtrx);
        System.out.println(matrix1 + "  *");
        Matrix<Integer> matrix2 = new Matrix<>(mtrx);
        System.out.println(matrix2 + "  =");

        Matrix<Integer> matrixRes = matrix1.multiply(matrix2);
        System.out.println(matrixRes);
        assertEquals(new Integer(9), matrixRes.getValue(0,0));
        assertEquals(new Integer(12), matrixRes.getValue(0,1));
    }

    @Test
    public void multiply1() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 1;
        mtrx[0][1] = 2;
        mtrx[1][0] = 4;
        mtrx[1][1] = 5;

        Matrix<Integer> matrix1 = new Matrix<>(mtrx);
        System.out.println(matrix1 + "  *");
        Integer i = new Integer(10);
        System.out.println("  " + i + "\n  =");

        Matrix<Integer> matrixRes = matrix1.multiply(i);
        System.out.println(matrixRes);
        assertEquals(new Integer(10), matrixRes.getValue(0,0));
        assertEquals(new Integer(20), matrixRes.getValue(0,1));
    }

    @Test
    public void divide() {
        Integer[][] mtrx = new Integer[2][2];
        mtrx[0][0] = 100;
        mtrx[0][1] = 222;
        mtrx[1][0] = 44;
        mtrx[1][1] = 56;

        Matrix<Integer> matrix1 = new Matrix<>(mtrx);
        System.out.println(matrix1 + "  /");
        Integer i = new Integer(10);
        System.out.println("  " + i + "\n  =");

        Matrix<Integer> matrixRes = matrix1.divide(i);
        System.out.println(matrixRes);
        assertEquals(new Integer(10), matrixRes.getValue(0,0));
        assertEquals(new Integer(22), matrixRes.getValue(0,1));
    }
}
