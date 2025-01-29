package D_29_01_25.Assignment2.Level2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class DateArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a date (YYYY-MM-DD): ");
        String inputDate = sc.nextLine();
        LocalDate date = LocalDate.parse(inputDate);
        LocalDate newDate = date.plusDays(7)
                .plusMonths(1)
                .plusYears(2)
                .minusWeeks(3);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.println("Modified date after calculations: " + newDate.format(formatter));
    }
}
