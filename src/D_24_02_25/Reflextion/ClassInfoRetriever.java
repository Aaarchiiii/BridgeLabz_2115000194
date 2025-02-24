package D_24_02_25.Reflextion;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Scanner;
public class ClassInfoRetriever {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full class name: ");
        String className = sc.nextLine();
        try {
            Class<?> clazz = Class.forName(className);
            System.out.println("\nClass: " + clazz.getName());
            System.out.println("\nFields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field);
            }
            System.out.println("\nMethods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method);
            }
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}
