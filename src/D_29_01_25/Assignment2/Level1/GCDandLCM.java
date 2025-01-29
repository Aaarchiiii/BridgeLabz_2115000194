package D_29_01_25.Assignment2.Level1;

import java.util.Scanner;
public class GCDandLCM {
    public static int takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextInt();
    }
    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static int calculateLCM(int a, int b) {
        int gcd = calculateGCD(a, b);
        return (a * b) / gcd;
    }
    public static void displayResult(int gcd, int lcm) {
        System.out.println("Greatest Common Divisor (GCD) is: " + gcd);
        System.out.println("Least Common Multiple (LCM) is: " + lcm);
    }
    public static void main(String[] args) {
        int num1 = takeInput("Enter the first number: ");
        int num2 = takeInput("Enter the second number: ");
        int gcd = calculateGCD(num1, num2);
        int lcm = calculateLCM(num1, num2);
        displayResult(gcd, lcm);
    }
}
