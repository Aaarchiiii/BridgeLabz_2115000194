package D_11_02_25;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;
    public Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
class MovieList {
    private Movie head;
    private Movie tail;
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = m;
            return;
        }
        m.next = head;
        head.prev = m;
        head = m;
    }
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        Movie m = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = m;
            return;
        }
        tail.next = m;
        m.prev = tail;
        tail = m;
    }
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position == 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        Movie m = new Movie(title, director, year, rating);
        Movie temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range");
            return;
        }
        m.next = temp.next;
        m.prev = temp;
        if (temp.next != null) {
            temp.next.prev = m;
        } else {
            tail = m;
        }
        temp.next = m;
    }
    public void removeMovie(String title) {
        if (head == null) {
            System.out.println("No movies to delete");
            return;
        }
        Movie temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Movie not found");
            return;
        }
        if (temp == head) {
            head = temp.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = temp.prev;
            if (tail != null) tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }
    public void searchMovieByDirector(String director) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equals(director)) {
                System.out.println("Title: " + temp.title + ", Year: " + temp.year + ", Rating: " + temp.rating);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found: ");
        }
    }
    public void searchMovieByRating(double rating) {
        Movie temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("No movies found");
        }
    }
    public void displayMoviesForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }
    public void displayMoviesReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director +
                    ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
    public void updateRating(String title, double newRating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for " + title);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }
}
public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieList l1 = new MovieList();
        l1.addMovieAtEnd("Animal", "Atle", 2022, 4);
        l1.addMovieAtEnd("KGF", "Mayank", 2018, 8);
        l1.addMovieAtBeginning("The date night", "Archi", 2020, 10);
        l1.addMovieAtPosition("Interstellar", "Christopher Nolan", 2014, 8.6, 2);
        System.out.println("Movie List (Forward):");
        l1.displayMoviesForward();
        System.out.println("Movie List (Reverse):");
        l1.displayMoviesReverse();
        System.out.println("Searching for movies by Director 'Christopher Nolan':");
        l1.searchMovieByDirector("Christopher Nolan");
        System.out.println("Searching for movies with Rating 8:");
        l1.searchMovieByRating(8);
        System.out.println("Updating rating of 'Animal' to 7:");
        l1.updateRating("Animal", 7);
        l1.displayMoviesForward();
        System.out.println("Removing 'The date night':");
        l1.removeMovie("The date night");
        l1.displayMoviesForward();
    }
}