package com.demos;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void testInheritanceAndFactorial() {
        MathOperation op = new FactorialOp();
        assertEquals("Factorial of 5 should be 120", 120, op.execute(5));
        assertEquals("Factorial of 0 should be 1", 1, op.execute(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInput() {
        MathOperation op = new FactorialOp();
        op.execute(-1);
    }

    @Test
    public void testUpperLimit() {
        MathOperation op = new FactorialOp();
        // 20! is the maximum value for a signed 64-bit long
        assertEquals(2432902008176640000L, op.execute(20));
    }
}