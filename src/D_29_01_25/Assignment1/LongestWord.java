package D_29_01_25.Assignment1;
import java.util.Scanner;
public class LongestWord {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String s = sc.nextLine();
        String[] words = s.split(" ");
        String longest = "";
        int max = 0;
        for(String word:words){
            if(word.length()>max){
                max=word.length();
                longest=word;
            }
        }
        System.out.println("The longest word in a string is "+longest+" with maximum length of "+max);
    }
}
