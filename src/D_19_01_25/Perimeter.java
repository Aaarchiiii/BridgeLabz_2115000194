package D_19_01_25;

import java.util.Scanner;
public class Perimeter{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length");
		float l = sc.nextFloat();
		System.out.println("Enter width");
		float w = sc.nextFloat();
		float p = 2*(l+w);
		System.out.println(p);
	}
}	
	