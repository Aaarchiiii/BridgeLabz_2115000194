package D_20_02_25;
import java.util.*;
import java.io.*;
class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String department;
    private double salary;
    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
public class Serialization {
    private static final String FILE_NAME = "employees.ser";
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Archi", "HR", 50000));
        employees.add(new Employee(2, "Mayank", "IT", 60000));
        employees.add(new Employee(3, "Khushi", "Finance", 70000));
        serializeEmployee(employees);
        deserializeEmployee();
    }
    public static void serializeEmployee(List<Employee> employees) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(employees);
            System.out.println("Employees serialized successfully");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public static void deserializeEmployee() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Employee> employees = (List<Employee>) ois.readObject();
            System.out.println("Deserialized employees:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error during deserialization: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
