package D_22_01_25.Level1;
import java.util.Scanner;
public class FindTheDistance {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float distanceFeet = sc.nextFloat();
        float distanceYard = (float)(distanceFeet/3);
        float distanceMiles = (float)(distanceYard/1760);
        System.out.println("Distance in feet is "+distanceFeet+" while in yard is "+distanceYard+" and in miles is "+distanceMiles);
    }
}
