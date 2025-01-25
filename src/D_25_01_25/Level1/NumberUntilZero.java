package D_25_01_25.Level1;
import java.util.Scanner;
public class NumberUntilZero {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter up to 10 numbers. Enter 0 or a negative number to stop:");
        while (true) {
            System.out.print("Enter a number: ");
            double input = scanner.nextDouble();
            if (input <= 0) {
                break;
            }
            numbers[index] = input;
            index++;
            if (index == 10) {
                break;
            }
        }
        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }
        System.out.println("\n\nTotal sum: " + total);
    }
}
