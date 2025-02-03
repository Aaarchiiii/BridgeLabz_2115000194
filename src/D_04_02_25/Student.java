package D_04_02_25;

public class Student {
    static String universityName = "GLA University";
    private String name;
    final private int rollNumber;
    private char grade;
    static int count = 0;
    public Student(String name, int rollNumber, char grade){
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        count++;
    }
    static void displayTotalStudents(){
        System.out.println("Total number of students: "+count);
    }
    public void Display(){
        System.out.println("Name: "+name);
        System.out.println("Roll Number: "+rollNumber);
        System.out.println("Grade: "+grade);
    }
    public static void main(String[] args) {
        Student s1 = new Student("Mayank", 1, 'A');
        System.out.println(s1 instanceof Student);
        s1.displayTotalStudents();
        s1.Display();
    }
}
