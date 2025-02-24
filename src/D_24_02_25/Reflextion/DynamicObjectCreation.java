package D_24_02_25.Reflextion;

import java.lang.reflect.Constructor;
class Student {
    private String name;
    private int age;
    public Student() {
        this.name = "Default Name";
        this.age = 0;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Student Name: " + name + ", Age: " + age);
    }
}
public class DynamicObjectCreation {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("Student");
            Constructor<?> defaultConstructor = clazz.getDeclaredConstructor();
            Object student1 = defaultConstructor.newInstance();
            ((Student) student1).display();
            Constructor<?> paramConstructor = clazz.getDeclaredConstructor(String.class, int.class);
            Object student2 = paramConstructor.newInstance("Archi", 21);
            ((Student) student2).display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
