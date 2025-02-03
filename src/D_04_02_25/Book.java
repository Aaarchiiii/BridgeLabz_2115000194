package D_04_02_25;

public class Book {
    static String libraryName = "Central Library";
    private String title;
    private String author;
    final private String isbn;
    public Book(String title, String author, String isbn){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
    static void displayLibraryName(){
        System.out.println("Library name: "+libraryName);
    }
    public void Display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("ISBN: "+isbn);
    }
    public static void main(String[] args){
        Book b1 = new Book("It ends with us", "Coolen Hover", "A101");
        System.out.println(b1 instanceof Book);
        b1.displayLibraryName();
        b1.Display();
    }
}
