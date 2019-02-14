package ru.letnes.testing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private iCalculator calc;

    @Before
    public void setUp() throws Exception {
        this.calc = new Calculator(0);
    }

    @After
    public void tearDown() throws Exception {
        this.calc = null;
    }

    @Test
    public void testGetSum() {
        int sum = calc.getSum(6, 7);
        assertEquals(13, sum);
    }

    @Test
    public void testGetDivide() {
        int divide = calc.getDivide(100, 5);
        assertEquals(20, divide);
    }

    @Test
    public void testGetMultiple() {
        int multiple = calc.getMultiple(5, 6);
        assertEquals(30, multiple);
    }

    @Test
    public void testGetNumOps() {
        calc.getSum(6, 7);
        calc.getSum(9, 8);
        int numOps = calc.getNumOps();
        assertEquals(2, numOps);
    }

    @Test(expected = NullPointerException.class)
    public void testGetThrow() {
        calc.getThrow();
    }
}