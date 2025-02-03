package D_04_02_25;

public class Employee {
    static String companyName = "Capegemini";
    private String name;
    final private int id;
    private String designation;
    static int count = 0;
    public Employee(String name, int id, String designation){
        this.name = name;
        this.id = id;
        this.designation = designation;
        count++;
    }
    static void displayTotalEmployees(){
        System.out.println("Total number of Employees: "+count);
    }
    public void Display(){
        System.out.println("Name of the employee: "+name);
        System.out.println("Id of the employee:" +id);
        System.out.println("Designation of the employee: "+designation);
    }
    public static void main(String[] args){
        Employee e1 = new Employee("Ram", 101, "Software Developer");
        System.out.println(e1 instanceof Employee);
        e1.displayTotalEmployees();
        e1.Display();
    }
}
