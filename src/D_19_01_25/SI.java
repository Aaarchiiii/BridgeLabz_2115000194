package D_19_01_25;

import java.util.Scanner;
public class SI{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Principal");
		float p = sc.nextFloat();
		System.out.println("Enter Rate");
		float r = sc.nextFloat();
		System.out.println("Enter Time");
		float t = sc.nextFloat();
		float s = (p*r*t)/100;
		System.out.println(s);
	}
}	