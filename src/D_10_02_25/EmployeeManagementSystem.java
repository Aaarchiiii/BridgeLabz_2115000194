package D_10_02_25;
import java.util.*;
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public String getName() {
        return name;
    }
    public double getBaseSalary() {
        return baseSalary;
    }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    public abstract double calculateSalary();
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println("Final Salary: " + calculateSalary());
    }
}
interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}
class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double fixedSalary;
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedSalary) {
        super(employeeId, name, baseSalary);
        this.fixedSalary = fixedSalary;
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedSalary;
    }
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        FullTimeEmployee emp1 = new FullTimeEmployee(101, "Archi", 50000, 20000);
        emp1.assignDepartment("Finance");
        PartTimeEmployee emp2 = new PartTimeEmployee(102, "Mayank", 20000, 20, 500);
        emp2.assignDepartment("HR");
        employees.add(emp1);
        employees.add(emp2);
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
        }
    }
}
