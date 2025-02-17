package D_17_02_25;

import java.util.*;
public class Fibonacci {
    public static int Recursive(int n) {
        if (n <= 1) return n;
        return Recursive(n - 1) + Recursive(n - 2);
    }
    public static int Iterative(int n) {
        if (n <= 1) return n;
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
    public static void main(String[] args) {
        int[] fibonacciValues = {10, 30, 50};
        for (int n : fibonacciValues) {
            System.out.println("Fibonacci Number: " + n);
            long startTime = System.nanoTime();
            int recursiveResult = Recursive(n);
            long endTime = System.nanoTime();
            System.out.println("Recursive Time: " + (endTime - startTime) / 1e6 + " ms");
            startTime = System.nanoTime();
            int iterativeResult = Iterative(n);
            endTime = System.nanoTime();
            System.out.println("Iterative Time: " + (endTime - startTime) / 1e6 + " ms");
        }
    }
}
