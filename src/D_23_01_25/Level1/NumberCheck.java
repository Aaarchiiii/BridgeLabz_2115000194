package D_23_01_25.Level1;
import java.util.Scanner;
public class NumberCheck {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number>0){
            System.out.println("The number is positive");
        }
        else if(number<0){
            System.out.println("The number is negative");
        }
        else{
            System.out.println("The number is zero");
        }
    }
}
