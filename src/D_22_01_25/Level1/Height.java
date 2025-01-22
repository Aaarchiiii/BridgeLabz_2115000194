package D_22_01_25.Level1;
import java.util.Scanner;
public class Height {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        float feet =(float) (height/30.48);
        float inches = (float) (height/2.54);
        System.out.println("Your Height in cm is "+height+" while in feet is "+feet+" and inches is "+inches);
    }
}
