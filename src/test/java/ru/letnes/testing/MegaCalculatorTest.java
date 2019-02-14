package ru.letnes.testing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class MegaCalculatorTest {
    private MegaCalculator megaCalc;
    @Mock
    private iCalculator calc;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
        this.megaCalc = new MegaCalculator(calc);
    }

    @Test
    public void getMultipleSum() {
        int x = 2;
        int y = 3;
        int z = 4;

        when(calc.getSum(x, y)).thenReturn(5);
        when(calc.getMultiple(eq(z), eq(5))).thenReturn(20);
        int multipleSum = megaCalc.getMultipleSum(x, y, z);
        assertEquals(20, multipleSum);
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