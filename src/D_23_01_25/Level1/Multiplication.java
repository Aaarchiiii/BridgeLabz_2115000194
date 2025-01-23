package D_23_01_25.Level1;
import java.util.Scanner;
public class Multiplication {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i=6; i<=9; i++){
            int table = number*i;
            System.out.println(number+" * "+i+" = "+table);
        }
    }
}
