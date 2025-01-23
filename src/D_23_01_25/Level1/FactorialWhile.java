package D_23_01_25.Level1;
import java.util.Scanner;
public class FactorialWhile {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int temp = number;
        if(number>0){
            int fac = 1;
            while(number>0){
                fac = fac*number;
                number--;
            }
            System.out.println("Factorial of "+temp+" is "+fac);
        }
        else{
            System.out.println("The "+temp+" is not positive number");
        }
    }
}
