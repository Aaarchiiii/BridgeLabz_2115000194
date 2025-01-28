package D_28_01_25.Level2;
import java.util.Scanner;
public class UnitConvertor {
    public static double convertKmToMiles(double km){
        double miles = km*0.621371;
        return miles;
    }
    public static double convertMilesToKm(double miles){
        double km = miles*1.60934;
        return km;
    }
    public static double convertmetersToFeet(double meters){
        double feet = meters*3.28084;
        return feet;
    }
    public static double convertFeetToMeters(double feet){
        double meters = feet*0.3048;
        return meters;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter distance in km");
        double km = sc.nextDouble();
        System.out.println("Enter distance in meters");
        double meters = sc.nextDouble();
        System.out.println("Distance in miles "+convertKmToMiles(km));
        System.out.println("Distance in km "+convertMilesToKm(convertKmToMiles(km)));
        System.out.println("Distance in feet "+convertmetersToFeet(meters));
        System.out.println("Distance in meters "+convertFeetToMeters(convertmetersToFeet(meters)));
    }
}
