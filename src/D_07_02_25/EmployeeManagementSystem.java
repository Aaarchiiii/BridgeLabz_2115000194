package D_07_02_25;
class Employee{
    String name;
    int id;
    double salary;
    public Employee(String name, int id, double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    public void displayDetails(){
        System.out.println("ID: "+id+" Name: "+name+" Salary "+salary);
    }
}
class Manager extends Employee{
    int teamSize;
    public Manager(String name, int id, double salary, int teamSize){
        super(name, id, salary);
        this.teamSize = teamSize;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Manager, Team Size: "+teamSize);
    }
}
class Developer extends Employee{
    String programmingLanguage;
    public Developer(String name, int id, double salary, String programmingLanguage){
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Role: Developer, Programming Language: "+programmingLanguage);
    }
}
class Intern extends Employee{
    public Intern(String name, int id, double salary){
        super(name, id, salary);
    }
    @Override
    public void displayDetails(){
        super.displayDetails();
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Manager manager = new Manager("Archi", 101, 600000, 10);
        Developer developer = new Developer("Mayank", 102, 500000, "Java");
        Intern intern = new Intern("Khushi", 103, 400000);
        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}