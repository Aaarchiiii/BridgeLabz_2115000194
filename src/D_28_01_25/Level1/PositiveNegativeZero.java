package D_28_01_25.Level1;
import java.util.Scanner;
public class PositiveNegativeZero {
    public static int CheckNumber(int number){
        if(number>0){
            return 1;
        }
        else if(number<0){
            return -1;
        }
        else{
            return 0;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number to check");
        int number = sc.nextInt();
        int num = CheckNumber(number);
        if(num==1){
            System.out.println(number+" is a positive number");
        }
        else if(num==-1){
            System.out.println(number+" is a negative number");
        }
        else{
            System.out.println(number+" is a zero");
        }
    }
}
