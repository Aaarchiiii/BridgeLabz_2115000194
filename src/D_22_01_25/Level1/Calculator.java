package D_22_01_25.Level1;
import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int addition = number1+number2;
        int subtraction = number1-number2;
        int multiplication = number1*number2;
        float division = (float)number1/number2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+addition+" , "+subtraction+" , "+multiplication+" , and "+division);
    }
}
