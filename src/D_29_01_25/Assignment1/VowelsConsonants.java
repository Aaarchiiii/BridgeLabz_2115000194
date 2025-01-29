package D_29_01_25.Assignment1;
import java.util.Scanner;
public class VowelsConsonants {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String input = sc.next();
        String lower = input.toLowerCase();
        char[] arr = lower.toCharArray();
        int vowels = 0;
        int consonants = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u'){
                vowels++;
            }
            else{
                consonants++;
            }
        }
        System.out.println("Number of vowels in "+input+ " are "+vowels+" and consonants are "+consonants);
    }
}
