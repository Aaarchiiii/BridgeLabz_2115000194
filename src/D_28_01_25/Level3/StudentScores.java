package D_28_01_25.Level3;

import java.util.*;
public class StudentScores {
    public static int[][] generateScores(int students){
        int[][] scores=new int[students][3];
        Random random=new Random();
        for(int i=0;i<students;i++)
            for(int j=0;j<3;j++)
                scores[i][j]=random.nextInt(41)+60;
        return scores;
    }
    public static double[][] calculateResults(int[][] scores){
        int students=scores.length;
        double[][] results=new double[students][3];
        for(int i=0;i<students;i++){
            int total=scores[i][0]+scores[i][1]+scores[i][2];
            double avg=total/3.0;
            double percentage=(total/300.0)*100;
            results[i][0]=total;
            results[i][1]=Math.round(avg*100.0)/100.0;
            results[i][2]=Math.round(percentage*100.0)/100.0;
        }
        return results;
    }
    public static void displayScorecard(int[][] scores,double[][] results){
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage\tRemark");
        for(int i=0;i<scores.length;i++){
            System.out.print((i+1)+"\t");
            System.out.print(scores[i][0]+"\t\t"+scores[i][1]+"\t\t"+scores[i][2]+"\t");
            System.out.print((int)results[i][0]+"\t");
            System.out.print(results[i][1]+"\t");
            System.out.print(results[i][2]+"\t\t");
            if(results[i][2]>=80)
                System.out.println("Level:4 Above agency-normalized standards");
            else if(results[i][2]>=70&&results[i][2]<=79)
                System.out.println("Level:3 At agency-normalized standards");
            else if(results[i][2]>=60&&results[i][2]<=69)
                System.out.println("Level:2 Below but approaching agency-normalized standards");
            else if(results[i][2]>=50&&results[i][2]<=59)
                System.out.println("Level:1 Well below agency-normalized standards");
            else if(results[i][2]>=40&&results[i][2]<=49)
                System.out.println("Level:1- Too below agency-normalized standards");
            else
                System.out.println("Level:4 Remedial standards");
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of students:");
        int students=sc.nextInt();
        int[][] scores=generateScores(students);
        double[][] results=calculateResults(scores);
        displayScorecard(scores,results);
    }
}
