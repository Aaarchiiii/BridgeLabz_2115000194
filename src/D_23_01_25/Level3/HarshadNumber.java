package D_23_01_25.Level3;
import java.util.Scanner;
public class HarshadNumber {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        int temp = number;
        int sum = 0;
        while(temp>0){
            int digit = temp%10;
            sum = sum+digit;
            temp = temp/10;
        }
        if(number%sum==0){
            System.out.println(number+" is a Harshad Number.");
        }
        else{
            System.out.println(number+" is not a Harshad Number.");
        }
    }
}
