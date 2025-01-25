package D_25_01_25.Level2;

import java.util.Scanner;
public class Grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        double[] physicsMarks = new double[n];
        double[] chemistryMarks = new double[n];
        double[] mathsMarks = new double[n];
        double[] percentages = new double[n];
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            do {
                System.out.print("Enter marks in Physics: ");
                physicsMarks[i] = sc.nextDouble();
                if (physicsMarks[i] < 0) {
                    System.out.println("Marks cannot be negative. Please enter valid marks.");
                }
            } while (physicsMarks[i] < 0);
            do {
                System.out.print("Enter marks in Chemistry: ");
                chemistryMarks[i] = sc.nextDouble();
                if (chemistryMarks[i] < 0) {
                    System.out.println("Marks cannot be negative. Please enter valid marks.");
                }
            } while (chemistryMarks[i] < 0);
            do {
                System.out.print("Enter marks in Maths: ");
                mathsMarks[i] = sc.nextDouble();
                if (mathsMarks[i] < 0) {
                    System.out.println("Marks cannot be negative. Please enter valid marks.");
                }
            } while (mathsMarks[i] < 0);
            double totalMarks = physicsMarks[i] + chemistryMarks[i] + mathsMarks[i];
            percentages[i] = (totalMarks / 300) * 100;
            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            }
            else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R";
            }
        }
        System.out.println("\nStudent Results:");
        System.out.println("Student | Physics | Chemistry | Maths | Percentage | Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d| %-8.2f| %-10.2f| %-6.2f| %-11.2f| %s\n",
                    (i + 1), physicsMarks[i], chemistryMarks[i], mathsMarks[i], percentages[i], grades[i]);
        }
    }
}

