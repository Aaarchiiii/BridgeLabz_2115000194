package D_29_01_25.Assignment1;
import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String input = sc.nextLine();
        String reverse = "";
        for(int i=input.length()-1; i>=0; i--){
            reverse += input.charAt(i);
        }
        if(input.equals(reverse)){
            System.out.println("It is a palindrome string");
        }
        else{
            System.out.println("It is not a palindrome string");
        }
    }
}
