package D_23_01_25.Level3;
import java.util.Scanner;
public class CountDigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        int count = 0;
        while(number>0){
            int digit = number%10;
            count++;
            number = number/10;
        }
        System.out.println("Number of digits are "+count);
    }
}
