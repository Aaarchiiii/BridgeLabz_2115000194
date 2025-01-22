package D_22_01_25.Level1;
import java.util.Scanner;
public class SideOfSquare {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float perimeter = sc.nextFloat();
        float side = (float) (perimeter/4);
        System.out.println("The length of the side is "+side+" whose perimeter is "+perimeter);
    }
}
