package D_22_01_25.Level1;
import java.util.Scanner;
public class AreaOfTriangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float baseCm = sc.nextFloat();
        float heightCm = sc.nextFloat();
        float areaCm = (float)(1/2f*baseCm*heightCm);
        float areaInches = (float)(areaCm/2.54f*2.54f);
        float areaFeet = (float)(areaInches/144f);
        System.out.println("Area of circle in cm is "+areaCm+" while in feet is "+areaFeet+" and in inches is "+areaInches);
    }
}
