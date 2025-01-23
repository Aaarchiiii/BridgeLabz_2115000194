package D_23_01_25.Level1;
import java.util.Scanner;
public class Bonus {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int salary = sc.nextInt();
        int year = sc.nextInt();
        if(year>5){
            float bonus = (float) (salary*0.05);
            System.out.println("Bonus amount "+bonus);
        }
        else{
            System.out.println("No bonus");
        }
    }
}
