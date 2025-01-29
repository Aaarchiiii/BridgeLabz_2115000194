package D_29_01_25.Assignment1;
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String input = sc.nextLine().trim();
        String reverse = " ";
        for(int i=input.length()-1; i>=0; i--){
            reverse += input.charAt(i);
        }
        System.out.println("Reversed string is "+reverse);
    }
}
