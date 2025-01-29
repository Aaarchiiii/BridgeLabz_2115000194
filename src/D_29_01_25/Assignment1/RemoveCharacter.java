package D_29_01_25.Assignment1;
import java.util.Scanner;
public class RemoveCharacter {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter string and character to remove");
        String s = sc.nextLine().trim();
        char ch = sc.next().charAt(0);
        String remove = s.replace(String.valueOf(ch), "");
        System.out.println("String after removing character "+remove);
    }
}
