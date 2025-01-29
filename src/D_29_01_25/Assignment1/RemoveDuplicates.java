package D_29_01_25.Assignment1;
import java.util.Scanner;
public class RemoveDuplicates {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string");
        String input = sc.nextLine();
        String ans = "";
        for(int i=0; i<input.length(); i++){
            char temp = input.charAt(i);
            if(temp != ' '){
                if(ans.indexOf(temp)<=-1){
                    ans = ans+temp;
                }
            }
            else{
                ans = ans+' ';
            }
        }
        ans = ans.trim();
        System.out.println("String after removing duplicates "+ans);
    }
}
