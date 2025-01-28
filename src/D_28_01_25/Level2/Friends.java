package D_28_01_25.Level2;

import java.util.Scanner;

public class Friends{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        int[] height = new int[3];
        System.out.println("Enter ages of all three:");
        for (int i = 0; i < 3; i++) {
            age[i] = sc.nextInt();
        }
        System.out.println("Enter heights of all three:");
        for (int i = 0; i < 3; i++) {
            height[i] = sc.nextInt();
        }
        Youngest(age);
        Tallest(height);
    }
    public static void Youngest(int age[]) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (age[i] < age[youngestIndex]) {
                youngestIndex = i;
            }
        }
        System.out.println("The youngest is " + names[youngestIndex] + " with age " + age[youngestIndex]);
    }
    public static void Tallest(int height[]) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (height[i] > height[tallestIndex]) {
                tallestIndex = i;
            }
        }
        System.out.println("The tallest is " + names[tallestIndex] + " with height " + height[tallestIndex]);
    }
}