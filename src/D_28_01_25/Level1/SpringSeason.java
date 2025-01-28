package D_28_01_25.Level1;
import java.util.Scanner;
public class SpringSeason {
    public static boolean CheckSpring(int month, int day) {
        if (month == 3 && day >= 20 && day <= 31) {
            return true;
        } else if (month == 4 && day >= 1 && day <= 30) {
            return true;
        } else if (month == 5 && day >= 1 && day <= 31) {
            return true;
        } else if (month == 6 && day >= 1 && day <= 20) {
            return true;
        } else {
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter month");
        int month = sc.nextInt();
        System.out.println("Enter day");
        int day = sc.nextInt();
        boolean spring = CheckSpring(month, day);
        if(spring==true){
            System.out.println("It is a spring season");
        }
        else{
            System.out.println("It is not a spring season");
        }
    }
}
