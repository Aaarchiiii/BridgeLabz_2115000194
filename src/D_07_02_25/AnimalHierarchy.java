package D_07_02_25;

class Animal {
    String name;
    int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void makeSound() {
        System.out.println("Animal sound...");
    }
}
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}
class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
}
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }
}
public class AnimalHierarchy {
    public static void main(String[] args) {
       Dog dog = new Dog("Messy", 4);
       Cat cat = new Cat("Kittu", 5);
       Bird bird = new Bird("Tweety", 2);
       dog.makeSound();
       cat.makeSound();
       bird.makeSound();
    }
}
