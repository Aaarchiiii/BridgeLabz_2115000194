package D_24_02_25.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}
class User1 {
    private String role;
    public User1(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }
}
class SecureService {
    @RoleAllowed("ADMIN")
    public void adminTask() {
        System.out.println("Executing admin task...");
    }
    @RoleAllowed("USER")
    public void userTask() {
        System.out.println("Executing user task...");
    }
}
public class RoleAccessControl {
    public static void main(String[] args) {
        User1 adminUser = new User1("ADMIN");
        User1 regularUser = new User1("USER");
        SecureService service = new SecureService();
        executeMethodIfAllowed(service, "adminTask", adminUser);
        executeMethodIfAllowed(service, "adminTask", regularUser);
        executeMethodIfAllowed(service, "userTask", regularUser);
    }
    private static void executeMethodIfAllowed(Object obj, String methodName, User1 user) {
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName);
            if (method.isAnnotationPresent(RoleAllowed.class)) {
                String requiredRole = method.getAnnotation(RoleAllowed.class).value();
                if (user.getRole().equals(requiredRole)) {
                    method.invoke(obj);
                } else {
                    System.out.println("Access Denied! " + user.getRole() + " cannot execute " + methodName);
                }
            } else {
                method.invoke(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
