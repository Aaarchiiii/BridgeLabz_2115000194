package D_28_01_25.Level1;
import java.util.Scanner;
public class TrignometricFunctions {
    public static double[] calculateTrigonometricFunctions(double angle){
        double radians = Math.toRadians(angle);
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        return new double[]{sine, cosine, tangent};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter angle in degrees");
        double angle = sc.nextDouble();
        double[] calculate = calculateTrigonometricFunctions(angle);
        System.out.println("The value of sin"+angle+" is "+calculate[0]);
        System.out.println("The value of cos"+angle+" is "+calculate[1]);
        System.out.println("The value of tan"+angle+" is "+calculate[2]);
    }
}
