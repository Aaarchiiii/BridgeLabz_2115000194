package D_11_02_25;

class Student{
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;
    public Student(int rollNumber, String name, int age, String grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentList{
    private Student head;
    public void addStudentAtBeginning(int rollNumber, String name, int age, String grade){
        Student st = new Student(rollNumber, name, age, grade);
        st.next = head;
        head = st;
    }
    public void addStudentAtEnd(int rollNumber, String name, int age, String grade){
        Student st = new Student(rollNumber, name, age, grade);
        if(head == null){
            head = st;
            return;
        }
        Student temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = st;
    }
    public void addStudentAtPosition(int rollNumber, String name, int age, String grade, int position){
        if(position == 0){
            addStudentAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student st = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for(int i=0; i<position-1; i++){
            if(temp==null){
                System.out.println("Position not exist");
                return;
            }
            temp = temp.next;
        }
        st.next = temp.next;
        temp.next = st;
    }
    public void deleteStudent(int rollNumber){
        if(head!=null && head.rollNumber == rollNumber){
            head = head.next;
            return;
        }
        Student temp = head;
        Student prev = null;
        while(temp!=null && temp.rollNumber != rollNumber){
            prev = temp;
            temp = temp.next;
        }
        if(temp==null){
            System.out.println("Student not exist");
            return;
        }
        prev.next = temp.next;
    }
    public String searchStudent(int rollNumber){
        Student temp = head;
        while(temp!=null){
            if(temp.rollNumber == rollNumber){
                return "Roll No.: "+temp.rollNumber+" Name: "+temp.name+" Age: "+temp.age+" Grade: "+temp.grade;
            }
            temp = temp.next;
        }
        return "Student not exist";
    }
    public void displayStudents(){
        Student temp = head;
        while(temp != null){
            System.out.println("Roll No.: "+temp.rollNumber+" Name: "+temp.name+" Age: "+temp.age+" Grade: "+temp.grade);
            temp = temp.next;
        }
    }
    public String updateGrade(int rollNumber, String newGrade){
        Student temp = head;
        while (temp!=null){
            if(temp.rollNumber == rollNumber){
                temp.grade = newGrade;
                return "Grade updated";
            }
            temp = temp.next;
        }
        return "Student not exist";
    }
}
public class StudentRecordManagement {
    public static void main(String[] args){
        StudentList l1 = new StudentList();
        l1.addStudentAtEnd(1, "Archi", 22, "A");
        l1.addStudentAtEnd(2, "Mayank", 21, "B");
        l1.addStudentAtBeginning(3, "Khushi", 20, "D");
        l1.addStudentAtPosition(4, "krishna", 19, "B", 3);
        l1.displayStudents();
        System.out.println("Searching: "+l1.searchStudent(4));
        System.out.println("Updation: "+l1.updateGrade(2, "A"));
        l1.displayStudents();
        l1.deleteStudent(3);
        l1.displayStudents();
    }
}
