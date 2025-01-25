package D_25_01_25.Level2;

import java.util.Scanner;
public class Friends {
    public static void main(String[] args) {
        String[] friends = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < friends.length; i++) {
            System.out.print("Enter age for " + friends[i]);
            ages[i] = sc.nextInt();
            System.out.print("Enter height for " + friends[i]);
            heights[i] = sc.nextDouble();
        }
        int youngestIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        int tallestIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        System.out.println("\nThe youngest friend is " + friends[youngestIndex] + " with age " + ages[youngestIndex] + " years.");
        System.out.println("The tallest friend is " + friends[tallestIndex] + " with height " + heights[tallestIndex] + " cm.");
    }
}