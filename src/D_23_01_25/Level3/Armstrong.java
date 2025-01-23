package D_23_01_25.Level3;
import java.util.Scanner;
public class Armstrong {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        int sum = 0;
        int originalNumber = number;
        while(originalNumber!=0){
            int remainder = originalNumber%10;
            sum = sum+(remainder*remainder*remainder);
            originalNumber = originalNumber/10;
        }
        if(sum==number){
            System.out.println(number+" is an Armstrong number");
        }
        else{
            System.out.println(number+" is not an Armstrong number");
        }
    }
}
