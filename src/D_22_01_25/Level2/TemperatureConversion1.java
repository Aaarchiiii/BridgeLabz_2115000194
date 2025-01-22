package D_22_01_25.Level2;

import java.util.Scanner;
public class TemperatureConversion1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float fahrenheit = sc.nextFloat();
        float celsius = (float)((fahrenheit-32)*5/9);
        System.out.println("The "+fahrenheit+" fahrenheit is "+celsius+" celsius ");
    }
}
