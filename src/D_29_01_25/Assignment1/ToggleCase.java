package D_29_01_25.Assignment1;

import java.util.Scanner;
public class ToggleCase {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str = input.nextLine().trim();
        String toggleCase = "";
        for(char i : str.toCharArray()){
            if(Character.isUpperCase(i)){
                toggleCase += Character.toLowerCase(i);
            }
            else{
                toggleCase += Character.toUpperCase(i);
            }
        }
        System.out.println("Toggle case : " + toggleCase);
    }
}

