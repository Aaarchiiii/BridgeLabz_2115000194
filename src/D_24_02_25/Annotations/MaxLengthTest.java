package D_24_02_25.Annotations;
import java.lang.annotation.*;
import java.lang.reflect.Field;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength{
    int value();
}
class User{
    @MaxLength(10)
    private String username;
    public User(String username){
        validateMaxLength(this, username);
        this.username = username;
    }
    private void validateMaxLength(Object obj, String fieldValue){
        try{
            Field field = obj.getClass().getDeclaredField("username");
            if(field.isAnnotationPresent(MaxLength.class)){
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if(fieldValue.length() > maxLength){
                    throw new IllegalArgumentException("Username exceeds max length of "+maxLength+" characters.");
                }
            }
        }
        catch (NoSuchFieldException e){
            e.printStackTrace();
        }
    }
    public String getUsername(){
        return username;
    }
}
public class MaxLengthTest {
    public static void main(String[] args) {
        try{
            User user1 = new User("Archi");
            System.out.println("User created: "+user1.getUsername());
            User user2 = new User("MayankGautam1416");
        }
        catch (IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
