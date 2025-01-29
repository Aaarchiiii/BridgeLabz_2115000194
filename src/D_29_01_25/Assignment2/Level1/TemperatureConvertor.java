package D_29_01_25.Assignment2.Level1;

import java.util.Scanner;

public class TemperatureConvertor {
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static double takeInput(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextDouble();
    }
    public static void displayResult(double temperature, String scale) {
        System.out.println("The converted temperature is: " + temperature + " " + scale);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the conversion:");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = sc.nextInt();
        if (choice == 1) {
            double fahrenheit = takeInput("Enter the temperature in Fahrenheit: ");
            double celsius = fahrenheitToCelsius(fahrenheit);
            displayResult(celsius, "Celsius");
        } else if (choice == 2) {
            double celsius = takeInput("Enter the temperature in Celsius: ");
            double fahrenheit = celsiusToFahrenheit(celsius);
            displayResult(fahrenheit, "Fahrenheit");
        } else {
            System.out.println("Invalid choice. Please enter 1 or 2.");
        }
    }
}

