package ru.letnes.testing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.spy;

@RunWith(Parameterized.class)
public class OtherCalcTest {
    private iCalculator calc;
    private MegaCalculator megaCalc;
    private int parameter1;
    private int parameter2;
    private int parameter3;

    public OtherCalcTest(int parameter1, int parameter2, int parameter3) {
        this.parameter1 = parameter1;
        this.parameter2 = parameter2;
        this.parameter3 = parameter3;
    }

    @Before
    public void setUp() throws Exception {
        this.calc = spy(new Calculator(0));
        this.megaCalc = new MegaCalculator(calc);
    }

    @Parameterized.Parameters
    public static Collection getParameters() {
        return Arrays.asList(new Object[][]{
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7}});
    }

    @Test
    public void getMultipleSum() {
        int multipleSum = megaCalc.getMultipleSum(parameter1, parameter2, parameter3);
        System.out.println(multipleSum);
    }

    @Test
    public void givenString_whenConditions_thenCorrect() {
        String string = "Petya";
        assertThat(string, anyOf(containsString("Pet"), endsWith("tya")));
    }

    @Test
    public void givenNumber_whenConditions_thenCorrect() {
        Integer intVal = 7;
        assertThat(intVal, allOf(greaterThan(5), lessThanOrEqualTo(7), not(equalTo(6))));
    }
}