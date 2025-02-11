package D_11_02_25;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;
    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketReservationSystem {
    private Ticket last;
    private int totalTickets = 0;
    public TicketReservationSystem() {
        last = null;
    }
    public void bookTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket ticket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (last == null) {
            last = ticket;
            last.next = last;
        } else {
            ticket.next = last.next;
            last.next = ticket;
            last = ticket;
        }
        totalTickets++;
        System.out.println("Ticket booked successfully: " + ticketId);
    }
    public void cancelTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }
        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) {
                    last = null;
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev;
                    }
                }
                totalTickets--;
                System.out.println("Ticket " + ticketId + " canceled.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket not found.");
    }
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                    ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }
    public void searchTicket(String keyword) {
        if (last == null) {
            System.out.println("No tickets available.");
            return;
        }
        Ticket temp = last.next;
        boolean found = false;
        do {
            if (temp.customerName.equals(keyword) || temp.movieName.equals(keyword)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber +
                        ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != last.next);
        if (!found) {
            System.out.println("No matching tickets found.");
        }
    }
    public int getTotalTickets() {
        return totalTickets;
    }
}
public class OnlineTicketReservation {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.bookTicket(101, "Archi", "KGF", "A2", "12:00 PM");
        system.bookTicket(102, "Mayank", "Wednesday", "B4", "2:00 PM");
        system.bookTicket(103, "Khushi", "KGF", "C5", "12:00 PM");
        System.out.println("All Booked Tickets:");
        system.displayTickets();
        System.out.println("Searching for tickets booked for 'KGF':");
        system.searchTicket("KGF");
        System.out.println("Canceling Ticket 102:");
        system.cancelTicket(102);
        System.out.println("Updated Ticket List:");
        system.displayTickets();
        System.out.println("Total Tickets Booked: " + system.getTotalTickets());
    }
}
