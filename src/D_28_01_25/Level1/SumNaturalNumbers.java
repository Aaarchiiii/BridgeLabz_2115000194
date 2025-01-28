package D_28_01_25.Level1;
import java.util.Scanner;
public class SumNaturalNumbers {
    public static int Sum(int number){
        int sum = 0;
        for(int i=1; i<=number; i++){
            sum = sum+i;
        }
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        int total = Sum(number);
        System.out.println("The sum of "+number+" natural numbers is "+total);
    }
}
