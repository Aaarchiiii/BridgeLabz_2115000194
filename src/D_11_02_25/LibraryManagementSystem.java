package D_11_02_25;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;
    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}
class Library {
    private Book head;
    private Book tail;
    private int bookCount = 0;
    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book book = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = book;
        } else {
            book.next = head;
            head.prev = book;
            head = book;
        }
        bookCount++;
    }
    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book book = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = book;
        } else {
            tail.next = book;
            book.prev = tail;
            tail = book;
        }
        bookCount++;
    }
    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }
        Book book = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
            return;
        }
        book.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = book;
        } else {
            tail = book;
        }
        temp.next = book;
        book.prev = temp;
        bookCount++;
    }
    public void removeBook(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book temp = head;
        while (temp != null && temp.bookId != bookId) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Book not found.");
            return;
        }
        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
        bookCount--;
    }
    public void searchBookByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equals(title)) {
                System.out.println("Book Found: " + temp.title + " ID: " + temp.bookId +
                        " Author: " + temp.author + " Genre: " + temp.genre +
                        " Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found.");
    }
    public void searchBookByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equals(author)) {
                System.out.println("Book Found: " + temp.title + " ID: " + temp.bookId +
                        " Author: " + temp.author + " Genre: " + temp.genre +
                        " Available: " + (temp.isAvailable ? "Yes" : "No"));
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No books found by this author.");
    }
    public void updateAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Availability updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found.");
    }
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Library Books (Forward Order):");
        Book temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " ID: " + temp.bookId +
                    " Author: " + temp.author + " Genre: " + temp.genre +
                    " Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.next;
        }
    }
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("Library Books (Reverse Order):");
        Book temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + " ID: " + temp.bookId +
                    " Author: " + temp.author + " Genre: " + temp.genre +
                    " Available: " + (temp.isAvailable ? "Yes" : "No"));
            temp = temp.prev;
        }
    }
    public int getTotalBooks() {
        return bookCount;
    }
}
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBookAtEnd("It ends with us", "Coolen Hover", "Fiction", 101, true);
        library.addBookAtEnd("Haunting Adeline", "H.D. Carlton", "Classic", 102, true);
        library.addBookAtBeginning("Better than the movies", "Iyknn Painter", "Dystopian", 103, false);
        library.addBookAtPosition("She stood by me", "Tarun Vikash", "Adventure", 104, true, 2);
        System.out.println("Displaying books in forward order:");
        library.displayBooksForward();
        System.out.println("Displaying books in reverse order:");
        library.displayBooksReverse();
        System.out.println("Total books in the library: " + library.getTotalBooks());
        System.out.println("Searching for book titled 'She stood by me':");
        library.searchBookByTitle("She stood by me");
        System.out.println("Searching for books by 'Coolen Hover':");
        library.searchBookByAuthor("Coolen Hover");
        System.out.println("Updating availability of Book ID 101:");
        library.updateAvailability(101, false);
        library.displayBooksForward();
        System.out.println("Removing Book ID 103:");
        library.removeBook(103);
        library.displayBooksForward();
        System.out.println("Total books after removal: " + library.getTotalBooks());
    }
}
