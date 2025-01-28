package D_28_01_25.Level1;
import java.util.Scanner;
public class SI {
    public static double Calculate(double principal, double rate, double time){
        return (principal*rate*time)/100;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter principal");
        double principal = sc.nextDouble();
        System.out.println("Enter rate");
        double rate = sc.nextDouble();
        System.out.println("Enter time");
        double time = sc.nextDouble();
        double interest = Calculate(principal, rate, time);
        System.out.println("The simple interest is "+interest+" for principal "+principal+" ,rate of interest "+rate+" and time "+time);
    }
}
