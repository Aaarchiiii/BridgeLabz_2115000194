package D_29_01_25.Assignment2.Level1;

import java.util.Scanner;

public class Fibonacci {
    public static void generateFibonacci(int terms) {
        int first = 0, second = 1;
        if (terms >= 1) {
            System.out.print(first + " ");
        }
        if (terms >= 2) {
            System.out.print(second + " ");
        }
        for (int i = 3; i <= terms; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms for the Fibonacci sequence: ");
        int terms = sc.nextInt();
        if (terms <= 0) {
            System.out.println("Please enter a positive number of terms.");
        } else {
            System.out.println("Fibonacci sequence up to " + terms + " terms:");
            generateFibonacci(terms);
        }
    }
}
