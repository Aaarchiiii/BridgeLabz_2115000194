package D_01_02_25.Level1.Constructors;

public class Person {
    private String name;
    private int age;
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public Person(Person other){
        this.name = other.name;
        this.age = other.age;
    }
    public void Display(){
        System.out.println("The name of the person is "+name+" with age "+age);
    }
    public static void main(String[] args){
        Person p1 = new Person("Archi", 22);
        p1.Display();
        Person p2 = new Person(p1);
        p2.Display();
    }
}
