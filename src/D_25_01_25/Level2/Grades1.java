package D_25_01_25.Level2;

import java.util.Scanner;
public class Grades1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        double[][] marks = new double[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            do {
                System.out.print("Enter marks in Physics: ");
                marks[i][0] = sc.nextDouble();
                if (marks[i][0] < 0) {
                    System.out.println("Marks cannot be negative. Please enter valid marks.");
                }
            } while (marks[i][0] < 0);
            do {
                System.out.print("Enter marks in Chemistry: ");
                marks[i][1] = sc.nextDouble();
                if (marks[i][1] < 0) {
                    System.out.println("Marks cannot be negative. Please enter valid marks.");
                }
            } while (marks[i][1] < 0);
            do {
                System.out.print("Enter marks in Maths: ");
                marks[i][2] = sc.nextDouble();
                if (marks[i][2] < 0) {
                    System.out.println("Marks cannot be negative. Please enter valid marks.");
                }
            } while (marks[i][2] < 0);
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300) * 100;
            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            }
            else if (percentages[i] >= 50) {
                grades[i] = "D";
            }
            else if (percentages[i] >= 40) {
                grades[i] = "E";
            }else {
                grades[i] = "R";
            }
        }
        System.out.println("\nStudent Results:");
        System.out.println("Student | Physics | Chemistry | Maths | Percentage | Grade");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d| %-8.2f| %-10.2f| %-6.2f| %-11.2f| %s\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
