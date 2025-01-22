package D_22_01_25.Level2;

import java.util.Scanner;
public class TotalIncome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int bonus = sc.nextInt();
        int income = salary+bonus;
        System.out.println("The salary is INR "+salary+" and bonus is INR "+bonus+". Hence Total Income is INR "+income);
    }
}
