package D_24_02_25.Reflextion;

import java.lang.reflect.Field;
import java.util.Map;
class Person1 {
    private String name;
    private int age;
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
public class CustomObjectMapper {
    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            T instance = clazz.getDeclaredConstructor().newInstance();
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                Field field;
                try {
                    field = clazz.getDeclaredField(entry.getKey());
                } catch (NoSuchFieldException e) {
                    continue;
                }
                field.setAccessible(true);
                field.set(instance, entry.getValue());
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException("Error creating object", e);
        }
    }
    public static void main(String[] args) {
        Map<String, Object> properties = Map.of("name", "Archi", "age", 25);
        Person1 person = toObject(Person1.class, properties);
        person.display();
    }
}
