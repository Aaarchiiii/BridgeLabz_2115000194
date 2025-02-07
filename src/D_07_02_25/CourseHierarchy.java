package D_07_02_25;

class Course{
    private String courseName;
    private String duration;
    public Course(String courseName, String duration){
        this.courseName = courseName;
        this.duration = duration;
    }
    public void displayInfo(){
        System.out.println("Course Name: " + courseName + "\nDuration: " + duration);
    }
}
class OnlineCourse extends Course{
    private String platform;
    private String isRecorded;
    public OnlineCourse(String courseName, String duration, String platform,String isRecorded){
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Platform: " + platform + "\nRecorded: " + isRecorded);
    }
}
class PaidOnlineCourse extends OnlineCourse{
    private double fee;
    private float discount;
    public PaidOnlineCourse(String courseName, String duration, String platform,String isRecorded, double fee, float discount){
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Fee: " + fee + "$\nDiscount: " + discount +"%");
    }
}
public class CourseHierarchy {
    public static void main(String[] args) {
        Course course = new Course("Engineering", "4 Years");
        course.displayInfo();
        OnlineCourse onlineCourse = new OnlineCourse("Introduction to Data Science", "1 month", "Cisco Networking Academy", "Yes");
        onlineCourse.displayInfo();
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse("Google Data Analytics Professional Certificate", "1.5 Years", "Coursera", "Yes", 200, 90);
        paidOnlineCourse.displayInfo();
    }
}