package D_25_01_25.Level1;
import java.util.Scanner;
public class MeanHeight {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double[] heights = new double[11];
        System.out.println("Enter heights of players");
        for(int i=0; i<11; i++){
            heights[i] = sc.nextDouble();
        }
        double sum = 0.0;
        for(int i=0; i<11; i++){
            sum = sum+heights[i];
        }
        float meanHeight = (float) (sum/11);
        System.out.println("The mean height of the football team is "+meanHeight);
    }
}
