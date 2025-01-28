package D_28_01_25.Level2;
import java.util.Scanner;
public class LeapYear {
    public static int CheckLeapYear(int year){
        if(year%100==0){
            if(year%400==0){
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(year%4==0){
            return 1;
        }
        else{
            return -1;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter year");
        int year = sc.nextInt();
        int leap = CheckLeapYear(year);
        if(leap==1){
            System.out.println(year+ " is a leap year");
        }
        else{
            System.out.println(year+ " is not a leap year");
        }
    }
}
