package D_23_01_25.Level2;
import java.util.Scanner;
public class GreatestFactor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        int greatestFactor = 1;
        for(int i=number-1; i>0; i--){
            if(number%i==0){
                greatestFactor=i;
                break;
            }
        }
        System.out.println("The greatest factor of "+number+" is "+greatestFactor);
    }
}
