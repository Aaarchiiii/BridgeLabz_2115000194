package D_29_01_25.Assignment1;
import java.util.Arrays;
import java.util.Scanner;
public class Anagrams {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two strings");
        String s1 = sc.nextLine().trim().toLowerCase();
        String s2 = sc.nextLine().trim().toLowerCase();
        if(s1.length() != s2.length()){
            System.out.println("Both the strings are not anagrams");
        }
        else{
            char[] ch1 = s1.toCharArray();
            char[] ch2 = s2.toCharArray();
            Arrays.sort(ch1);
            Arrays.sort(ch2);
            if(Arrays.equals(ch1, ch2)){
                System.out.println("Both the strings are anagrams");
            }
            else{
                System.out.println("Both the strings are not anagrams");
            }
        }
    }
}
