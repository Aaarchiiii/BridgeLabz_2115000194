package D_23_01_25.Level2;
import java.util.Scanner;
public class Factor {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        for(int i=1; i<number; i++){
            if(number%i==0){
                System.out.println(i);
            }
        }
    }
}
