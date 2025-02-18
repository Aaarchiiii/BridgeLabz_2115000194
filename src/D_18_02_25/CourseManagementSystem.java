package D_18_02_25;
import java.util.*;
abstract class CourseType{
    protected String courseName;
    protected String department;
    public CourseType(String courseName, String department){
        this.courseName = courseName;
        this.department = department;
    }
    public abstract String getEvaluation();
    public void displayCourseDetails(){
        System.out.println("Course name: "+courseName+" Department: "+department+" Evaluation: "+getEvaluation());
    }
}
class ExamCourse extends CourseType{
    public ExamCourse(String courseName, String department){
        super(courseName, department);
    }
    @Override
    public String getEvaluation(){
        return "Exam based evaluation";
    }
}
class AssignmentCourse extends CourseType{
    public AssignmentCourse(String courseName, String department){
        super(courseName, department);
    }
    @Override
    public String getEvaluation(){
        return "Assignment based evaluation";
    }
}
class ResearchCourse extends CourseType{
    public ResearchCourse(String courseName, String department){
        super(courseName, department);
    }
    @Override
    public String getEvaluation(){
        return "Research based evaluation";
    }
}
class Course<T extends CourseType>{
    private T courseType;
    public Course(T courseType){
        this.courseType = courseType;
    }
    public T getCourseType(){
        return courseType;
    }
    public void displayCourseInfo(){
        courseType.displayCourseDetails();
    }
}
class CourseManager{
    public static void displayAllCourses(List<? extends CourseType> courses){
        for(CourseType course: courses){
            course.displayCourseDetails();
        }
    }
}
public class CourseManagementSystem {
    public static void main(String[] args) {
        ExamCourse examCourse = new ExamCourse("Physics", "Science");
        AssignmentCourse assignmentCourse = new AssignmentCourse("Civics", "Arts");
        ResearchCourse researchCourse = new ResearchCourse("Java", "CSE");
        Course<ExamCourse> physics = new Course<>(examCourse);
        Course<AssignmentCourse> civics = new Course<>(assignmentCourse);
        Course<ResearchCourse> java = new Course<>(researchCourse);
        physics.displayCourseInfo();
        civics.displayCourseInfo();
        java.displayCourseInfo();
        List<CourseType> allCourses = new ArrayList<>();
        allCourses.add(examCourse);
        allCourses.add(assignmentCourse);
        allCourses.add(researchCourse);
        System.out.println("All Courses");
        CourseManager.displayAllCourses(allCourses);
    }
}
