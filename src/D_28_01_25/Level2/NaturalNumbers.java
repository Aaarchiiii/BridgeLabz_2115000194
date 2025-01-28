package D_28_01_25.Level2;
import java.util.Scanner;
public class NaturalNumbers {
    public static int SumRecursion(int number){
        if(number==1){
            return 1;
        }
        return number+SumRecursion(number-1);
    }
    public static int FormulaSum(int number){
        int sum = (number*(number+1))/2;
        return sum;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        if(number<1){
            System.out.println("Not a natural number");
            System.exit(0);
        }
        int recursive = SumRecursion(number);
        int formula = FormulaSum(number);
        if(recursive==formula){
            System.out.println("The result of both the methods are same");
        }
        else{
            System.out.println("The result of both the methods are not same");
        }

    }
}
