package D_28_01_25.Level2;

import java.util.Scanner;

public class StudentVoteChecker {
    public static boolean canStudentVote(int age){
        if(age<0){
            return false;
        }
        else if(age>=18){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i=0; i<10; i++){
            arr[i] = sc.nextInt();
            boolean canVote = canStudentVote(arr[i]);
            if(canVote){
                System.out.println("Student can vote");
            }
            else{
                System.out.println("Student cannot vote");
            }
        }

    }
}
