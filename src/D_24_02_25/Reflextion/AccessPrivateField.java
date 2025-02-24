package D_24_02_25.Reflextion;

import java.lang.reflect.Field;
class Person {
    private int age;
    public Person(int age) {
        this.age = age;
    }
    public void displayAge() {
        System.out.println("Age: " + age);
    }
}
public class AccessPrivateField {
    public static void main(String[] args) {
        try {
            Person person = new Person(25);
            Field ageField = Person.class.getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.println("Original Age: " + ageField.get(person));
            ageField.set(person, 30);
            System.out.println("Modified Age: " + ageField.get(person));
            person.displayAge();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
