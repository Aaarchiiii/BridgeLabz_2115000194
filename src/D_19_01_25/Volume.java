package D_19_01_25;

import java.util.Scanner;
public class Volume{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter radius");
		int r = sc.nextInt();
		System.out.println("Enter height");
		int h = sc.nextInt();
		double V = 3.14 * r * r * h;
		System.out.println(V);
	}
}	