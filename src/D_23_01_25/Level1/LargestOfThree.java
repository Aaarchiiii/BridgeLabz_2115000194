package D_23_01_25.Level1;
import java.util.Scanner;
public class LargestOfThree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        if(number1>number2 && number1>number3){
            System.out.println("Is the first number the largest? Yes \nIs the second number the largest? No \nIs the third number the largest? No");
        }
        else if(number2>number1 && number2>number3){
            System.out.println("Is the first number the largest? No \nIs the second number the largest? Yes \nIs the third number the largest? No");
        }
        else{
            System.out.println("Is the first number the largest? No \nIs the second number the largest? No \nIs the third number the largest? Yes");
        }
    }
}
