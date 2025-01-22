package D_22_01_25.Level2;
import java.util.Scanner;
public class DivideChocolates {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfChocolates = sc.nextInt();
        int numberOfChildren = sc.nextInt();
        int chocolatesChildGet = numberOfChocolates/numberOfChildren;
        int remainingChocolates = numberOfChocolates%numberOfChildren;
        System.out.println("The number of chocolates each child gets is "+chocolatesChildGet+" and the number of remaining chocolates are "+remainingChocolates);
    }
}
