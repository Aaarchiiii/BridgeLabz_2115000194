package D_24_02_25.Reflextion;

import java.lang.reflect.Method;
class Sample {
    public void fastMethod() {
        System.out.println("Executing fast method...");
    }
    public void slowMethod() {
        System.out.println("Executing slow method...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class MethodTimer {
    public static void measureExecutionTime(Object obj, String methodName) {
        try {
            Method method = obj.getClass().getMethod(methodName);
            long startTime = System.nanoTime();
            method.invoke(obj);
            long endTime = System.nanoTime();
            System.out.println("Execution time of " + methodName + ": " + (endTime - startTime) / 1_000_000.0 + " ms");
        } catch (Exception e) {
            throw new RuntimeException("Error executing method: " + methodName, e);
        }
    }
}
public class ExecutionTimeMeasurement {
    public static void main(String[] args) {
        Sample sample = new Sample();
        MethodTimer.measureExecutionTime(sample, "fastMethod");
        MethodTimer.measureExecutionTime(sample, "slowMethod");
    }
}
