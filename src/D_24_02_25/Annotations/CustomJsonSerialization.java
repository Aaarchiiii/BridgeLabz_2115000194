package D_24_02_25.Annotations;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}
class User2 {
    @JsonField(name = "user_name")
    private String username;
    @JsonField(name = "user_age")
    private int age;
    public User2(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
class JsonSerializer {
    public static String serialize(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonElements = new HashMap<>();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(JsonField.class)) {
                    field.setAccessible(true);
                    String key = field.getAnnotation(JsonField.class).name();
                    String value = field.get(obj).toString();
                    jsonElements.put(key, value);
                }
            }
            return "{" + jsonElements.entrySet()
                    .stream()
                    .map(entry -> "\"" + entry.getKey() + "\": \"" + entry.getValue() + "\"")
                    .collect(Collectors.joining(", ")) + "}";
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error serializing object", e);
        }
    }
}
public class CustomJsonSerialization {
    public static void main(String[] args) {
        User2 user = new User2("Archi", 22);
        String jsonString = JsonSerializer.serialize(user);
        System.out.println(jsonString);
    }
}
