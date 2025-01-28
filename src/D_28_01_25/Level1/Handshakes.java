package D_28_01_25.Level1;

import java.util.Scanner;
public class Handshakes {
    public static int Maximum(int numberOfStudents){
        return (numberOfStudents*(numberOfStudents-1))/2;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students");
        int numberOfStudents = sc.nextInt();
        int maximum = Maximum(numberOfStudents);
        System.out.println("The maximum number of handshakes among "+numberOfStudents+" students are "+maximum);
    }
}