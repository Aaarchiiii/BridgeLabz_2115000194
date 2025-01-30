package D_31_01_25;
import java.util.Scanner;
public class Book {
    String title;
    String author;
    double price;
    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
    public void Display(String title, String author, double price){
        System.out.println("The title of the book is "+title+" with author name is "+author+" and price is "+price);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of the book");
        String title = sc.next();
        System.out.println("Enter author of the book");
        String author = sc.next();
        System.out.println("Enter price of the book");
        double price = sc.nextDouble();
        Book b = new Book(title, author, price);
        b.Display(title, author, price);
    }
}
