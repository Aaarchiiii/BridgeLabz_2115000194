package D_24_02_25.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
    String reportedBy();
}
class Software {
    @BugReport(description = "Null pointer exception is high", reportedBy = "Archi")
    @BugReport(description = "UI misalignment on dashboard", reportedBy = "Mayank")
    public void applicationFeature() {
        System.out.println("Executing application features...");
    }
}
public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            Method method = Software.class.getMethod("applicationFeature");
            if (method.isAnnotationPresent(BugReports.class)) {
                BugReports bugReports = method.getAnnotation(BugReports.class);
                for (BugReport bug : bugReports.value()) {
                    System.out.println("Bug: " + bug.description() + " Reported by: " + bug.reportedBy());
                }
            }
            new Software().applicationFeature();
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + e.getMessage());
        }
    }
}
