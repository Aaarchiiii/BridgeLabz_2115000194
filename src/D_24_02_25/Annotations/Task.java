package D_24_02_25.Annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo{
    String priority();
    String assignedTo();
}
class TaskManager{
    @TaskInfo(priority = "High", assignedTo = "Archi")
    public void completeTask(){
        System.out.println("Task is completed...");
    }
}
public class Task {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");
        if(method.isAnnotationPresent(TaskInfo.class)){
            TaskInfo info = method.getAnnotation(TaskInfo.class);
            System.out.println("Task Priority: "+info.priority());
            System.out.println("Assigned To: "+info.assignedTo());
        }
        new TaskManager().completeTask();
    }
}
