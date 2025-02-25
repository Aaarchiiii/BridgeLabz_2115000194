package D_25_02_25;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
public class CSVToStudentList {
    public static void main(String[] args) {
        String filePath = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/students.csv";
        try (FileReader reader = new FileReader(filePath)) {
            CsvToBean<Student> csvToBean = new CsvToBeanBuilder<Student>(reader)
                    .withType(Student.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<Student> students = csvToBean.parse();
            students.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Student {
    private int id;
    private String name;
    private int age;
    private double marks;
    public Student() {}
    public Student(int id, String name, int age, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }
    @Override
    public String toString() {
        return "Student{ ID=" + id + ", Name='" + name + "', Age=" + age + ", Marks=" + marks + " }";
    }
}
