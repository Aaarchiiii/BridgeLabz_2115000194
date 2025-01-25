package D_25_01_25.Level2;

import java.util.Scanner;
public class Largest {
    public static void main(String[] args) {
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        if (number <= 0) {
            System.out.println("Error: Please enter a positive number.");
            System.exit(0);
        }
        while (number != 0 && index < maxDigit) {
            digits[index++] = number % 10;
            number /= 10;
        }
        int largest = 0;
        int secondLargest = 0;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }
        System.out.println("\nThe largest digit is: " + largest);
        System.out.println("The second largest digit is: " + secondLargest);
    }
}
