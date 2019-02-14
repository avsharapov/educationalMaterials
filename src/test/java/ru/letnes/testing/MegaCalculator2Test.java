package ru.letnes.testing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class MegaCalculator2Test {
    private MegaCalculator megaCalc;
    private iCalculator calc;

    @Before
    public void setUp() throws Exception {
        this.calc = spy(new Calculator(0));
        this.megaCalc = new MegaCalculator(calc);
    }

    @Test
    public void getMultipleSum() {
        int x = 2;
        int y = 3;
        int z = 4;

        int multipleSum = megaCalc.getMultipleSum(x, y, z);
        assertEquals(20, multipleSum);
        verify(calc, times(1)).getSum(x, y);
        verify(calc, times(1)).getMultiple(anyInt(), anyInt());
    }

    @Test
    public void getCalc() {
        iCalculator calculator = megaCalc.getCalc();
        assertSame(this.calc, calculator);
    }

    @Test
    public void getNumOps() {
        when(calc.getNumOps()).thenReturn(2);
        int numOps = megaCalc.getNumOps();
        assertEquals(2, numOps);
    }
}