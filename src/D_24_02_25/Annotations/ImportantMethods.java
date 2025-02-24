package D_24_02_25.Annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod{
    String level() default "HIGH";
}
class Application{
    @ImportantMethod(level = "CRITICAL")
    public void processData(){
        System.out.println("Processing important data...");
    }
    @ImportantMethod
    public void saveData(){
        System.out.println("Saving important data...");
    }
    public void regularMethod(){
        System.out.println("This is a regular method.");
    }
}
public class ImportantMethods {
    public static void main(String[] args) {
        try{
            Method[] methods = Application.class.getDeclaredMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(ImportantMethod.class)){
                    ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                    System.out.println("Important Method: "+method.getName()+ " Level: "+ annotation.level());
                }
            }
            Application app = new Application();
            app.processData();
            app.saveData();
            app.regularMethod();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
