package D_29_01_25.Assignment2.Level2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateComparison {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print("Enter the first date (YYYY-MM-DD): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine(), formatter);
        System.out.print("Enter the second date (YYYY-MM-DD): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine(), formatter);
        if (date1.isBefore(date2)) {
            System.out.println("The first date is before the second date.");
        } else if (date1.isAfter(date2)) {
            System.out.println("The first date is after the second date.");
        } else {
            System.out.println("Both dates are the same.");
        }
    }
}
