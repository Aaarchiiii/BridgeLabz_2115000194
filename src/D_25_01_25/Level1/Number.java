package D_25_01_25.Level1;
import java.util.Scanner;
public class Number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] number = new int[5];
        System.out.println("Enter 5 numbers");
        for(int i=0; i<5; i++){
            number[i] = sc.nextInt();
        }
        for(int i=0; i<number.length; i++){
            if(number[i]>0){
                if(number[i]%2==0){
                    System.out.println(number[i]+" is even number");
                }
                else{
                    System.out.println(number[i]+" is odd number");
                }
            }
            else if(number[i]<0){
                System.out.println(number[i]+" is a negative number");
            }
            else{
                System.out.println(number[i]+" is a zero");
            }
        }
        if(number[0]==number[4]){
            System.out.println(number[0]+" and "+number[4]+" are equal");
        }
        else if(number[0]>number[4]){
            System.out.println(number[0]+" is greater than "+number[4]);
        }
        else{
            System.out.println(number[0]+" is less than "+number[4]);
        }
    }
}
