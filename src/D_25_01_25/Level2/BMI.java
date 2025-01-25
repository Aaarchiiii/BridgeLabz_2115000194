package D_25_01_25.Level2;

import java.util.Scanner;
public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = sc.nextInt();
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight ");
            weight[i] = sc.nextDouble();
            System.out.print("Enter height ");
            height[i] = sc.nextDouble();
            bmi[i] = weight[i] / (height[i] * height[i]);
            if (bmi[i] <= 18.4) {
                status[i] = "Underweight";
            } else if (bmi[i] >= 18.5 && bmi[i] < 24.9) {
                status[i] = "Normal weight";
            } else if (bmi[i] >= 25 && bmi[i] < 29.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        System.out.println("\nBMI Report:");
        System.out.println("Person | Height (m) | Weight (kg) | BMI      | Status");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-7d| %-12.2f| %-12.2f| %-9.2f| %s\n", (i + 1), height[i], weight[i], bmi[i], status[i]);
        }
    }
}