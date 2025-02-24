package D_24_02_25.Reflextion;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author {
    String name();
}
@Author(name = "Archi")
class MyClass {
    public void display() {
        System.out.println("Executing MyClass methods...");
    }
}
public class RetrieveAnnotations {
    public static void main(String[] args) {
        Class<MyClass> clazz = MyClass.class;
        if (clazz.isAnnotationPresent(Author.class)) {
            Author author = clazz.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        } else {
            System.out.println("No @Author annotation present.");
        }
    }
}
