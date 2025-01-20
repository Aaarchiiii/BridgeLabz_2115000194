package D_19_01_25;

import java.util.*;
public class Power{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value of base");
        int b = sc.nextInt();
        System.out.println("Enter value of exponent");
        int e = sc.nextInt();
        double p = Math.pow(b,e);
        System.out.println(p);
    }
}