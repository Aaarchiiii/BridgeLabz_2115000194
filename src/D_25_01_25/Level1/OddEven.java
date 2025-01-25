package D_25_01_25.Level1;
import java.util.Scanner;
public class OddEven {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number");
        int number = sc.nextInt();
        if(number<1){
            System.out.println("Error");
            System.exit(0);
        }
        int size = (number/2)+1;
        int[] even = new int[size];
        int[] odd = new int[size];
        int evenIndex = 0;
        int oddIndex = 0;
        for(int i=1; i<=number; i++){
            if(i%2==0){
                even[evenIndex++] = i;
            }
            else{
                odd[oddIndex++] = i;
            }
        }
        for(int i=0; i<oddIndex; i++){
            System.out.println("Odd numbers "+odd[i]+ " ");
        }
        for(int i=0; i<evenIndex; i++){
            System.out.println("Even numbers "+even[i]+ " ");
        }
    }
}
