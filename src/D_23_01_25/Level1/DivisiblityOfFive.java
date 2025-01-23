package D_23_01_25.Level1;
import java.util.Scanner;
public class DivisiblityOfFive {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(number%5==0){
            System.out.println("Is the number "+number+" divisible by 5? Yes");
        }
        else{
            System.out.println("Is the number "+number+" divisible by 5? No");
        }
    }
}
