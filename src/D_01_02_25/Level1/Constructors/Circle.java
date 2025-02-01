package D_01_02_25.Level1.Constructors;

import java.util.Scanner;

public class Circle {
    private double radius;
    public Circle(){
        this.radius = 1.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public void Display(){
        System.out.println("The radius is "+radius);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius");
        double radius = sc.nextDouble();
        Circle c1 = new Circle();
        c1.Display();
        Circle c2 = new Circle(radius);
        c2.Display();
    }
}
