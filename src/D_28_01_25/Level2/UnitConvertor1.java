package D_28_01_25.Level2;

import java.util.Scanner;
public class UnitConvertor1 {
    public static double convertYardsToFeet(double yards){
        double feet = yards*3;
        return feet;
    }
    public static double convertFeetToYards(double feet){
        double yards = feet*0.333333;
        return yards;
    }
    public static double convertmetersToInches(double meters){
        double inches = meters*39.3701;
        return inches;
    }
    public static double convertInchesToMeters(double inches){
        double meters = inches*0.0254;
        return meters;
    }
    public static double convertInchesToCMeters(double inches){
        double cmeters = inches*2.54;
        return cmeters;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter distance in yards");
        double yards = sc.nextDouble();
        System.out.println("Enter distance in meters");
        double meters = sc.nextDouble();
        System.out.println("Distance in feet "+convertYardsToFeet(yards));
        System.out.println("Distance in yards "+convertFeetToYards(convertYardsToFeet(yards)));
        System.out.println("Distance in inches "+convertmetersToInches(meters));
        System.out.println("Distance in meters "+convertInchesToMeters(convertmetersToInches(meters)));
        System.out.println("Distance in centimeters "+convertInchesToCMeters(convertmetersToInches(meters)));
    }
}
