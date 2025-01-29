package D_29_01_25.Assignment2.Level1;

import java.util.Scanner;
public class Calculator {
    public static double add(double a, double b) {
        return a + b;
    }
    public static double subtract(double a, double b) {
        return a - b;
    }
    public static double multiply(double a, double b) {
        return a * b;
    }
    public static double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Error! Division by zero is not allowed.");
            return Double.NaN;
        }
        return a / b;
    }
    public static double takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextDouble();
    }
    public static void displayResult(double result) {
        System.out.println("The result is: " + result);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Enter your choice ");
        int choice = sc.nextInt();
        double num1 = takeInput("Enter the first number: ");
        double num2 = takeInput("Enter the second number: ");
        double result = 0;
        boolean validOperation = true;
        switch (choice) {
            case 1:
                result = add(num1, num2);
                break;
            case 2:
                result = subtract(num1, num2);
                break;
            case 3:
                result = multiply(num1, num2);
                break;
            case 4:
                result = divide(num1, num2);
                break;
            default:
                System.out.println("Invalid choice! Please select a valid operation.");
                validOperation = false;
        }
        if (validOperation) {
            displayResult(result);
        }
    }
}
