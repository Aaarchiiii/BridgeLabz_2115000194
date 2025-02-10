package D_10_02_25;
import java.util.*;
abstract class LibraryItem{
    private int itemId;
    private String title;
    private String author;
    public LibraryItem(int itemId, String title, String author){
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    public int getItemId() {
        return itemId;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public abstract int getLoanDuration();
    public void getItemDetails(){
        System.out.println("Item Id: "+itemId);
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
    }
}
interface Reservable{
    boolean reserveItem();
    boolean checkAvailability();
}
class Book extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 14;
    private boolean isAvailable = true;
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() {
        return LOAN_DURATION;
    }
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book '" + getTitle() + "' reserved successfully.");
            return true;
        }
        System.out.println("Book '" + getTitle() + "' is already reserved.");
        return false;
    }
    public boolean checkAvailability() {
        return isAvailable;
    }
}
class Magazine extends LibraryItem {
    private static final int LOAN_DURATION = 7;

    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() {
        return LOAN_DURATION;
    }
}
class DVD extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 5;
    private boolean isAvailable = true;
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }
    public int getLoanDuration() {
        return LOAN_DURATION;
    }
    public boolean reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD '" + getTitle() + "' reserved successfully.");
            return true;
        }
        System.out.println("DVD '" + getTitle() + "' is already reserved.");
        return false;
    }
    public boolean checkAvailability() {
        return isAvailable;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();
        Book book = new Book(001, "The Great Gatsby", "F. Scott Fitzgerald");
        Magazine magazine = new Magazine(002, "National Geographic", "Various");
        DVD dvd = new DVD(003, "Inception", "Christopher Nolan");
        libraryItems.add(book);
        libraryItems.add(magazine);
        libraryItems.add(dvd);
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Availability: " + (reservableItem.checkAvailability() ? "Available" : "Not Available"));
                reservableItem.reserveItem();
            }
        }
    }
}