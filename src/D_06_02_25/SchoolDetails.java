package D_06_02_25;

import java.util.*;
class Course_1 {
    String courseName;
    ArrayList<Student_1> students;
    public Course_1(String courseName) {
        this.courseName = courseName;
        students = new ArrayList<>();
    }
    public void enrollStudent(Student_1 student) {
        students.add(student);
    }
    public void showStudents() {
        System.out.println("Course: " + courseName);
        for (Student_1 student : students) {
            System.out.println("  Student: " + student.studentName);
        }
    }
}
class Student_1 {
    String studentName;
    ArrayList<Course_1> courses;
    public Student_1(String studentName) {
        this.studentName = studentName;
        courses = new ArrayList<>();
    }
    public void enrollInCourse(Course_1 course) {
        courses.add(course);
        course.enrollStudent(this);
    }
    public void showCourses() {
        System.out.println("Student: " + studentName);
        for (Course_1 course : courses) {
            System.out.println("  Enrolled in: " + course.courseName);
        }
    }
}
class School {
    String schoolName;
    ArrayList<Student_1> students;
    public School(String schoolName) {
        this.schoolName = schoolName;
        students = new ArrayList<>();
    }
    public void addStudent(Student_1 student) {
        students.add(student);
    }
    public void showStudents() {
        System.out.println("School: " + schoolName);
        for (Student_1 student : students) {
            student.showCourses();
        }
    }
}
public class SchoolDetails {
    public static void main(String[] args) {
        School school = new School("Symboyzia School");
        Student_1 student1 = new Student_1("Ram");
        Student_1 student2 = new Student_1("Shyam");
        Course_1 course1 = new Course_1("English");
        Course_1 course2 = new Course_1("Hindi");
        school.addStudent(student1);
        school.addStudent(student2);
        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student2.enrollInCourse(course1);
        school.showStudents();
        course1.showStudents();
        course2.showStudents();
    }
}
