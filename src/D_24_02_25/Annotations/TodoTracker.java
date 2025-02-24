package D_24_02_25.Annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo{
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}
class ProjectModule{
    @Todo(task = "Implement login validation", assignedTo = "Archi", priority = "HIGH")
    public void validateLogin(){
        System.out.println("Validating login...");
    }
    @Todo(task = "Optimize database queries", assignedTo = "Mayank")
    public void optimizeDatabase(){
        System.out.println("Optimizing database....");
    }
    @Todo(task = "Enhance UI responsiveness", assignedTo = "Khushi", priority = "LOW")
    public void improveUI(){
        System.out.println("Improving UI....");
    }
}
public class TodoTracker {
    public static void main(String[] args) {
        try{
            Method[] methods = ProjectModule.class.getDeclaredMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(Todo.class)){
                    Todo todo = method.getAnnotation(Todo.class);
                    System.out.println("Pending Task: "+todo.task());
                    System.out.println("Assigned to: "+todo.assignedTo());
                    System.out.println("Priority: "+todo.priority());
                    System.out.println("Method: "+method.getName());
                }
            }
            ProjectModule module = new ProjectModule();
            module.validateLogin();
            module.optimizeDatabase();
            module.improveUI();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
