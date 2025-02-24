package D_24_02_25.Annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime{}
class PerformanceTest{
    @LogExecutionTime
    public void fastMethod(){
        System.out.println("Executing fast method....");
    }
    @LogExecutionTime
    public void slowMethod(){
        System.out.println("Executing slow method....");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class ExecutionTimeLogger {
    public static void main(String[] args) {
        try{
            PerformanceTest test = new PerformanceTest();
            Method[] methods = PerformanceTest.class.getDeclaredMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(LogExecutionTime.class)){
                    long startTime = System.nanoTime();
                    method.invoke(test);
                    long endTime = System.nanoTime();
                    long executionTime = (endTime - startTime)/1000000;
                    System.out.println("Execution time for: "+method.getName()+" : "+executionTime+" ms.");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
