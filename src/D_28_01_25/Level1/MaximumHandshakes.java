package D_28_01_25.Level1;
import java.util.Scanner;
public class MaximumHandshakes {
    public static int Maximum(int number){
        return (number*(number-1))/2;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students");
        int number = sc.nextInt();
        int maximum = Maximum(number);
        System.out.println("The maximum number of handshakes among "+number+" students are "+maximum);
    }
}
