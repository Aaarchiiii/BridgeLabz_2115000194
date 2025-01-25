package D_25_01_25.Level1;
import java.util.Scanner;
public class Multiplication {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int input = sc.nextInt();
        int[] arr = new int[11];
        for(int i=1; i<11; i++){
            arr[i] = input*i;
        }
        for(int i=1; i<11; i++){
            System.out.println(input+" * "+i+" = "+arr[i]);
        }
    }
}
