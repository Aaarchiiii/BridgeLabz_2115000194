package D_29_01_25.Assignment2.Level1;

import java.util.Scanner;
import java.util.Random;
public class NumberGuessingGame {
    public static int generateGuess(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + 1) + low;
    }
    public static String getFeedback() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Is the guess (high, low, or correct)? ");
        return sc.nextLine().toLowerCase();
    }
    public static void playGame() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the lower bound of the number range: ");
        int low = sc.nextInt();
        System.out.print("Enter the upper bound of the number range: ");
        int high = sc.nextInt();
        sc.nextLine();
        if (low >= high) {
            System.out.println("Invalid range. The lower bound must be less than the upper bound.");
            return;
        }
        int guess;
        String feedback;
        System.out.println("Think of a number between " + low + " and " + high + ", and I will try to guess it!");
        while (true) {
            guess = generateGuess(low, high);
            System.out.println("My guess is: " + guess);
            feedback = getFeedback();
            if (feedback.equals("correct")) {
                System.out.println("I guessed your number correctly!");
                break;
            } else if (feedback.equals("high")) {
                high = guess - 1;
            } else if (feedback.equals("low")) {
                low = guess + 1;
            } else {
                System.out.println("Invalid feedback! Please enter 'high', 'low', or 'correct'.");
            }
        }
    }
    public static void main(String[] args) {
        playGame();
    }
}
