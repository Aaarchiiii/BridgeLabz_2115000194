package D_19_01_25;

import java.util.Scanner;
public class Area{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius");
		int r = sc.nextInt();
		double A = 3.14 * r * r;
		System.out.println(A);
	}
}	
	