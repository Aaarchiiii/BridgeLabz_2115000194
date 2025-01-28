package D_28_01_25.Level1;
import java.util.Scanner;
public class TriangularPark {
    public static int Rounds(int Perimeter){
        return 5000/Perimeter;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter sides of triangle in meters");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int Perimeter = a+b+c;
        int rounds = Rounds(Perimeter);
        System.out.println("Number of rounds an athlete complete in a 5km run are "+rounds);
    }
}
