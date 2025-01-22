package D_22_01_25.Level1;
import java.util.Scanner;
public class MaximumNumberOfHandshakes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numberOfStudents = sc.nextInt();
        int possibleHandshakes = (numberOfStudents*(numberOfStudents-1))/2;
        System.out.println("The number of possible handshakes is "+possibleHandshakes+" when number of students are "+numberOfStudents);
    }
}
