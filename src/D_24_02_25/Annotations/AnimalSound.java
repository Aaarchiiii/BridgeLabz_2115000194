package D_24_02_25.Annotations;

class Animal{
    void makeSound(){
        System.out.println("Animals sounds");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Bark Bark...");
    }
}
public class AnimalSound {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();
    }
}
