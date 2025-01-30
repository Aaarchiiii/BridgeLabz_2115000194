package D_31_01_25;
import java.util.Scanner;
public class Circle {
    double radius;
    public Circle(double radius){
        this.radius = radius;
    }
    public double AreaOfCircle(double radius){
        double area = Math.PI * radius *radius;
        return area;
    }
    public double Circumference(double radius){
        double circumference = 2 * Math.PI * radius;
        return circumference;
    }
    public void Display(double ans){
        System.out.println(ans);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius");
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        System.out.println("The area of the circle is "+c.AreaOfCircle(radius));
        System.out.println("The circumference of the circle is "+c.Circumference(radius));
    }
}
