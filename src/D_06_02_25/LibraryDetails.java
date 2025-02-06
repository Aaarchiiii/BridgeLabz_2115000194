package D_06_02_25;

import java.util.*;
class Book {
    private String title;
    private String author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}
class Library {
    private ArrayList<Book> books;
    public Library() {
        books = new ArrayList<>();
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void displayBooks() {
        for (Book book : books) {
            book.displayDetails();
            System.out.println();
        }
    }
}
public class LibraryDetails {
    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Library library1 = new Library();
        Library library2 = new Library();
        library1.addBook(book1);
        library2.addBook(book2);
        System.out.println("Library 1 Books: ");
        library1.displayBooks();
        System.out.println("\nLibrary 2 Books: ");
        library2.displayBooks();
    }
}
