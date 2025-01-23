package D_23_01_25.Level2;
import java.util.Scanner;
public class Percentage {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter marks of physics");
        int physics = sc.nextInt();
        System.out.println("Enter marks of chemistry");
        int chemistry = sc.nextInt();
        System.out.println("Enter marks of maths");
        int maths = sc.nextInt();
        int total = physics+chemistry+maths;
        float percentage = (100*total/300);
        if(percentage>=80 && percentage<=100){
            System.out.println("Grade A and remark is Level 4, above agency-normalized standards");
        }
        else if(percentage>=70 && percentage<=79){
            System.out.println("Grade B and remark is Level 3, at agency-normalized standards");
        }
        else if(percentage>=60 && percentage<=69){
            System.out.println("Grade C and remark is Level 2, below, but approaching agency-normalized standards");
        }
        else if(percentage>=50 && percentage<=59){
            System.out.println("Grade D and remark is Level 1, well below agency-normalized standards");
        }
        else if(percentage>=40 && percentage<=49){
            System.out.println("Grade E and remark is Level 1-, too below agency-normalized standards");
        }
        else if(percentage<=39){
            System.out.println("Grade R and remark is remedial standards");
        }
    }
}
