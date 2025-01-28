package D_28_01_25.Level2;
import java.util.Scanner;
public class Number {
    public static String isPositive(int num){
        if(num>0)
            return "positive";
        else if(num<0)
            return "negative";
        else
            return "zero";
    }
    public static String isEven(int num){
        if(num%2==0)
            return "even";
        else
            return "odd";
    }
    public static String compare(int num1, int num2){
        if(num1>num2)
            return "first element of array is greater than last element";
        else if(num1<num2)
            return "first element of array is less than last element";
        else
            return "both are equal";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter numbers to check");
        int[] numArray=new int[5];
        for(int i=0;i<5;i++){
            numArray[i]=sc.nextInt();}
        for(int i=0;i<5;i++){
            if(isPositive(numArray[i])=="positive") {
                System.out.println(numArray[i]+" is positive");
                if(isEven(numArray[i])=="even") {
                    System.out.println(numArray[i]+" is even");
                }
                else
                    System.out.println(numArray[i]+" is odd");
            }
            else if((isPositive(numArray[i])=="negative"))
                System.out.println("negative");
            else
                System.out.println("zero");
        }
        System.out.println(compare(numArray[0],numArray[4]));
    }
}
