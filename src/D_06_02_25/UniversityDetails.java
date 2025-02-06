package D_06_02_25;

import java.util.*;
class University {
    String universityName;
    ArrayList<Department> departments;
    public University(String universityName) {
        this.universityName = universityName;
        departments = new ArrayList<>();
    }
    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }
    public void showDetails() {
        System.out.println("University: " + universityName);
        for (Department department : departments) {
            department.showDetails();
        }
    }
    public void deleteUniversity() {
        departments.clear();
        System.out.println("University and all associated departments deleted.");
    }
}
class Department {
    String departmentName;
    ArrayList<Faculty> facultyMembers;
    public Department(String departmentName) {
        this.departmentName = departmentName;
        facultyMembers = new ArrayList<>();
    }
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }
    public void showDetails() {
        System.out.println("  Department: " + departmentName);
        for (Faculty faculty : facultyMembers) {
            faculty.showDetails();
        }
    }
}
class Faculty {
    String facultyName;
    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }
    public void showDetails() {
        System.out.println("    Faculty: " + facultyName);
    }
}
public class UniversityDetails {
    public static void main(String[] args) {
        University university = new University("Tech University");
        university.addDepartment("Computer Science");
        university.addDepartment("Electrical Engineering");
        Department csDepartment = university.departments.get(0);
        Department eeDepartment = university.departments.get(1);
        Faculty faculty1 = new Faculty("Dr. Smith");
        Faculty faculty2 = new Faculty("Dr. Johnson");
        Faculty faculty3 = new Faculty("Dr. Lee");
        csDepartment.addFaculty(faculty1);
        eeDepartment.addFaculty(faculty2);
        eeDepartment.addFaculty(faculty3);
        university.showDetails();
        university.deleteUniversity();
        university.showDetails();
    }
}
