package D_28_01_25.Level1;
import java.util.Scanner;
public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor){
        int quotient = number/divisor;
        int remainder = number%divisor;
        return new int[]{quotient, remainder};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        System.out.println("Enter divisor");
        int divisor = sc.nextInt();
        int[] result = findRemainderAndQuotient(number, divisor);
        System.out.println("The quotient and remainder are "+result[0]+" and "+result[1]);
    }
}
