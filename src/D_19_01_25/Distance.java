package D_19_01_25;

import java.util.Scanner;
public class Distance{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter distance in kilometres");
		double k = sc.nextDouble();
		double m = (k * 0.621371);
		System.out.println(m);
	}
}	