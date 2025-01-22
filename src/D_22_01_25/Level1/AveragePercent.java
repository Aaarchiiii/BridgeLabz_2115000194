package D_22_01_25.Level1;

public class AveragePercent {
    public static void main(String[] args){
        int mathsMarks = 94;
        int physicsMarks = 95;
        int chemistryMarks = 96;
        double totalMarks = mathsMarks+physicsMarks+chemistryMarks;
        double percentMarks = (totalMarks/300)*100;
        System.out.println("Sam's average mark in PCM is "+percentMarks);
    }
}
