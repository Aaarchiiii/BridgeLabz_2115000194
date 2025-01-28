package D_28_01_25.Level1;
import java.util.Scanner;
public class WindChill {
    public static double calculateWindChill(double temperature, double windSpeed){
        double windchill = 35.74 + 0.6215 * temperature +(0.4275 * temperature - 35.75) * (Math.pow(windSpeed,0.16));
        return windchill;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the temperature");
        double temperature = sc.nextDouble();
        System.out.println("Enter wind speed");
        double windSpeed = sc.nextDouble();
        double chill = calculateWindChill(temperature, windSpeed);
        System.out.println("The wind chill temperature is "+chill);
    }
}
