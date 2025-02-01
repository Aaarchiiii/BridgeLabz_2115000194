package D_01_02_25.Level1.Constructors;

public class BookAvailable {
    private String title;
    private String author;
    private int price;
    private boolean isAvailable;
    public BookAvailable(){
        this.title = "";
        this.author = "";
        this.price = 0;
        this.isAvailable = true;
    }
    public BookAvailable(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true;
    }
    public void Display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: "+price);
        System.out.println("Available: "+isAvailable);
    }
    public void borrowBook(){
        if(isAvailable){
            isAvailable = false;
            System.out.println("Borrowed");
        }
        else{
            System.out.println("Not available");
        }
    }
    public static void main(String[] args){
        BookAvailable b1 = new BookAvailable();
        b1.Display();
        b1.borrowBook();
        b1.Display();
        BookAvailable b2 = new BookAvailable("Julius and Caesar", "William Shakespeare", 1200);
        b2.Display();
        b2.borrowBook();
        b2.Display();
    }
}
