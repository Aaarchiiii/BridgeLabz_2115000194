package D_22_01_25.Level1;
import java.util.Scanner;
public class Conversion {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        double km = input.nextDouble();
        double miles = km*1.6;
        System.out.println("The total miles is "+miles+" mile for the given "+km+" km");
    }
}
