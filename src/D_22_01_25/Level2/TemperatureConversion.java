package D_22_01_25.Level2;
import java.util.Scanner;
public class TemperatureConversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float celsius = sc.nextFloat();
        float fahrenheit = (float)((celsius*9/5)+32);
        System.out.println("The "+celsius+" celsius is "+fahrenheit+" fahrenheit ");
    }
}
