package D_31_01_25;
import java.util.Scanner;
public class Employee {
    String name;
    int id;
    int salary;
    public Employee(String name, int id, int salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void Display(String name, int id, int salary){
        System.out.println("The name of the person is "+name+" with id "+id+" and salary is "+salary);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.next();
        System.out.println("Enter id");
        int id = sc.nextInt();
        System.out.println("Enter salary");
        int salary = sc.nextInt();
        Employee emp = new Employee(name, id, salary);
        emp.Display(name, id, salary);
    }
}
