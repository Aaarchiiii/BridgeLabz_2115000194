package D_29_01_25.Assignment1;
import java.util.Scanner;
public class FrequentCharacter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String s = sc.nextLine().trim();
        int[] freq = new int[256];
        int max = 0;
        char frequent = ' ';
        for(char ch:s.toCharArray()){
            freq[ch]++;
            if(freq[ch]>max){
                max=freq[ch];
                frequent=ch;
            }
        }
        System.out.println("Most frequent character is "+frequent);
    }
}
