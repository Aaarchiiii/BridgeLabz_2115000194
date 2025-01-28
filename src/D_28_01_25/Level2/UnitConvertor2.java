package D_28_01_25.Level2;

import java.util.Scanner;
public class UnitConvertor2 {
    public static double convertFahrenheitToCelsius(double fahrenheit){
        double celsius = (fahrenheit-32)*5/9;
        return celsius;
    }
    public static double convertCelsiusToFahrenheit(double celsius){
        double fahrenheit = (celsius*9/5)+32;
        return fahrenheit;
    }
    public static double convertPoundsToKg(double pounds){
        double kg = pounds*0.453592;
        return kg;
    }
    public static double convertKgToPounds(double kg){
        double pounds = kg*2.20462;
        return pounds;
    }
    public static double convertGallonsToLiters(double gallons){
        double liters = gallons*3.78541;
        return liters;
    }
    public static double convertLitersToGallons(double liters){
        double gallons = liters*0.264172;
        return gallons;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter temperature in fahrenheit");
        double fahrenheit = sc.nextDouble();
        System.out.println("Enter temperature in celsius");
        double celsius = sc.nextDouble();
        System.out.println("Enter weight in pounds");
        double pounds = sc.nextDouble();
        System.out.println("Enter weight in kilograms");
        double kg = sc.nextDouble();
        System.out.println("Enter weight in gallons");
        double gallons = sc.nextDouble();
        System.out.println("Enter weight in liters");
        double liters = sc.nextDouble();
        System.out.println("Temperature in fahrenheit "+convertCelsiusToFahrenheit(celsius));
        System.out.println("Temperature in celsius "+convertFahrenheitToCelsius(fahrenheit));
        System.out.println("Weight in Kg "+convertPoundsToKg(pounds));
        System.out.println("Weight in pounds "+convertKgToPounds(kg));
        System.out.println("Weight in gallons "+convertLitersToGallons(liters));
        System.out.println("Weight in liters "+convertGallonsToLiters(gallons));
    }
    }