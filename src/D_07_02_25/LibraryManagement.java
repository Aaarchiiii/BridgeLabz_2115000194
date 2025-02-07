package D_07_02_25;
class Book{
    String title;
    int publicationYear;
    public Book(String title, int publicationYear){
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo(){
        System.out.println("Title: "+title+" , Publication Year "+publicationYear);
    }
}
class Author extends Book{
    String name;
    String bio;
    public Author(String title, int publicationYear, String name, String bio){
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Name: "+name+" , Bio: "+bio);
    }
}
public class LibraryManagement {
    public static void main(String[] args){
        Author author = new Author("It Ends With Us", 2020, "Coolen Hover", "He is a fiction writer");
        author.displayInfo();
    }
}
