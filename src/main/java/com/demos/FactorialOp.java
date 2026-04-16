package com.demos;

public class FactorialOp implements MathOperation {
    @Override
    public long calculate(int n) {
        if (n < 0) throw new IllegalArgumentException("Number must be non-negative.");
        if (n == 0 || n == 1) return 1;
        
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}