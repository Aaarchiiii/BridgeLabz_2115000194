package D_23_01_25.Level2;
import java.util.Scanner;
public class Multiple {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number below 100");
        int number = sc.nextInt();
        for(int i=100; i>0; i--){
            if(number%i==0){
                System.out.println(i);
                continue;
            }
        }
    }
}
