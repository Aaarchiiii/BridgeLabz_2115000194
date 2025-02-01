package D_01_02_25.Level1.InstanceVsClassVariables;

public class Course {
    private String courseName;
    private int duration;
    private double fee;
    private static String instituteName = "GLA University";
    public Course(){
        this.courseName = "";
        this.duration = 0;
        this.fee = 0.0;
    }
    public Course(String courseName, int duration, double fee){
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    public void displayCourseDetails(){
        System.out.println("Course Name: "+courseName);
        System.out.println("Duration: "+duration);
        System.out.println("Fees: "+fee);
        System.out.println("Institute Name: "+instituteName);
    }
    public static void updateInstitueName(String newInstituteName){
        instituteName = newInstituteName;
    }
    public static void main(String[] args){
        Course c1 = new Course();
        c1.displayCourseDetails();
        Course c2 = new Course("Java", 6, 500);
        Course c3 = new Course("Data Science", 12, 1200);
        c2.displayCourseDetails();
        c3.displayCourseDetails();
        Course.updateInstitueName("Bridge Labzz");
        System.out.println("After updation");
        c2.displayCourseDetails();
        c3.displayCourseDetails();
    }
}
