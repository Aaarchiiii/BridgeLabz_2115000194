package D_23_01_25.Level1;
import java.util.Scanner;
public class FactorialFor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number>0){
            int fac = 1;
            for(int i=number; i>0; i--){
                fac = fac*i;
            }
            System.out.println("The factorial of "+number+" is "+fac);
        }
        else{
            System.out.println("The "+number+" is not positive");
        }
    }
}
