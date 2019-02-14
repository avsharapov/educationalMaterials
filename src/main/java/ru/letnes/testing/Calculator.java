package ru.letnes.testing;

public class Calculator implements iCalculator{
    private int numOps;

    public Calculator(int numOps) {
        this.numOps = numOps;
    }

    public int getSum(int x, int y) {
        numOps++;
        return x+y;
    }

    public int getDivide(int x, int y) {
        numOps++;
        return x/y;
    }

    public int getMultiple(int x, int y) {
        numOps++;
        return x*y;
    }

    public int getNumOps() {
        return numOps;
    }

    public void getThrow() {
        throw new NullPointerException("NullPointer");
    }
}
