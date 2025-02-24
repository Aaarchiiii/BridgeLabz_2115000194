package D_24_02_25.Reflextion;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
class Person2 {
    private String name;
    private int age;
    private boolean isActive;
    public Person2(String name, int age, boolean isActive) {
        this.name = name;
        this.age = age;
        this.isActive = isActive;
    }
}
public class ObjectToJson {
    public static String toJson(Object obj) {
        try {
            Class<?> clazz = obj.getClass();
            Map<String, String> jsonMap = new HashMap<>();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                String key = "\"" + field.getName() + "\"";
                Object value = field.get(obj);
                String valueStr = (value instanceof String) ? "\"" + value + "\"" : value.toString();
                jsonMap.put(key, valueStr);
            }
            return "{" + jsonMap.entrySet()
                    .stream()
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(Collectors.joining(", ")) + "}";
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error serializing object", e);
        }
    }
    public static void main(String[] args) {
        Person2 person = new Person2("Archi", 25, true);
        String jsonString = toJson(person);
        System.out.println(jsonString);
    }
}
