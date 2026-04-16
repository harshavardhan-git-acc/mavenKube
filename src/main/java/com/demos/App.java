package com.demos;

// Base Class demonstrating Inheritance
abstract class MathOperation {
    protected String name;
    public MathOperation(String name) { this.name = name; }
    public abstract long execute(int n);
}

// Derived Class
class FactorialOp extends MathOperation {
    public FactorialOp() { super("Factorial"); }

    @Override
    public long execute(int n) {
        if (n < 0) throw new IllegalArgumentException("Input must be non-negative");
        if (n > 20) throw new IllegalArgumentException("Input too large (max 20)");
        long res = 1;
        for (int i = 1; i <= n; i++) res *= i;
        return res;
    }
}

public class App {
    public static void main(String[] args) throws InterruptedException {
        // Polymorphism: Parent reference to Child object
        MathOperation op = new FactorialOp();
        
        System.out.println("Java CI/CD Application Started...");
        System.out.println("Executing " + op.name + " for input 5...");
        System.out.println("Result: " + op.execute(5));
        
        // Loop to keep the container active for Kubernetes verification
        while (true) {
            Thread.sleep(10000);
            System.out.println("Harshavardhan D. - App is running and responding.");
        }
    }
}