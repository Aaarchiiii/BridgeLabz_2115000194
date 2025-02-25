package D_23_01_25.Level2;
import java.util.Scanner;
public class Power {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        System.out.println("Enter power");
        int power = sc.nextInt();
        int result = 1;
        for(int i=1; i<=power; i++){
            result = result*number;
        }
        System.out.println(number+" raise to the power "+power+" = "+result);
    }
}
