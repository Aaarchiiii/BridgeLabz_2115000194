package D_28_01_25.Level1;

import java.util.Scanner;
public class Chocolates {
    public static int[] findRemainderAndQuotient(int chocolates, int children){
        int quotient = chocolates/children;
        int remainder = chocolates%children;
        return new int[]{quotient, remainder};
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of chocolates");
        int chocolates = sc.nextInt();
        System.out.println("Enter number of childrens");
        int children = sc.nextInt();
        int[] result = findRemainderAndQuotient(chocolates, children);
        System.out.println("The quotient and remainder are "+result[0]+" and "+result[1]);
    }
}