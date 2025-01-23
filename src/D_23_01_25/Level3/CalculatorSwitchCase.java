package D_23_01_25.Level3;

import java.util.Scanner;

public class CalculatorSwitchCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double first = sc.nextDouble();
        System.out.println("Enter the second number: ");
        double second = sc.nextDouble();
        System.out.println("Enter an operator");
        String op = sc.next();
        double result;
        switch (op) {
            case "+":
                result = first + second;
                System.out.println("The result of " + first + " + " + second + " = " + result);
                break;

            case "-":
                result = first - second;
                System.out.println("The result of " + first + " - " + second + " = " + result);
                break;

            case "*":
                result = first * second;
                System.out.println("The result of " + first + " * " + second + " = " + result);
                break;

            case "/":
                if (second != 0) {
                    result = first / second;
                    System.out.println("The result of " + first + " / " + second + " = " + result);
                } else {
                    System.out.println("Division by zero is not allowed.");
                }
                break;

            default:
                System.out.println("Invalid operator. Please use +, -, *, or /.");
        }
    }
}
