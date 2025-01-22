package D_22_01_25.Level2;
import java.util.Scanner;
public class WeightConversion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        float weightKg = sc.nextFloat();
        float weightPounds = (float) (weightKg/2.2);
        System.out.println("The weight of the person in pound is "+weightPounds+" and in kg is "+weightKg);
    }
}
