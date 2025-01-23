package D_23_01_25.Level2;
import java.util.Scanner;
public class Friends {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter age of Amar");
        int amarage = sc.nextInt();
        System.out.println("Enter age of Akbar");
        int akbarage = sc.nextInt();
        System.out.println("Enter age of Anthony");
        int anthonyage = sc.nextInt();
        System.out.println("Enter height of Amar");
        int amarh = sc.nextInt();
        System.out.println("Enter height of Akbar");
        int akbarh = sc.nextInt();
        System.out.println("Enter height of Anthony");
        int anthonyh = sc.nextInt();
        if(amarage<akbarage && amarage<anthonyage){
            System.out.println("Amar is youngest");
        }
        else if(akbarage<amarage && akbarage<anthonyage){
            System.out.println("Akbar is youngest");
        }
        else{
            System.out.println("Anthony is youngest");
        }
        if(amarh>akbarh && amarh>anthonyh){
            System.out.println("Amar is tallest");
        }
        else if(akbarh>amarh && akbarh>anthonyh){
            System.out.println("Akbar is tallest");
        }
        else{
            System.out.println("Anthony is tallest");
        }
    }
}
