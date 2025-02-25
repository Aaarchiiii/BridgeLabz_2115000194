package D_23_01_25.Level2;
import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year to check");
        int year = sc.nextInt();
        if(year%100==0){
            if(year%400==0){
                System.out.println(year+" is a leap year");
            }
            else{
                System.out.println(year+" is not a leap year");
            }
        }
        else if(year%4==0){
            System.out.println(year+" is a leap year");
        }
        else{
            System.out.println(year+" is not a leap year");
        }
    }
}
