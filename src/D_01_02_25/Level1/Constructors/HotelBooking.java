package D_01_02_25.Level1.Constructors;

public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;
    public HotelBooking(){
        this.guestName = "";
        this.roomType = "";
        this.nights = 0;
    }
    public HotelBooking(String guestName, String roomType, int nights){
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    public HotelBooking(HotelBooking other){
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }
    public void Display(){
        System.out.println("The guest name is "+guestName+" having room type "+roomType+" and number of nights are "+nights);
    }
    public static void main(String[] args){
        HotelBooking h1 = new HotelBooking();
        h1.Display();
        HotelBooking h2 = new HotelBooking("Archi", "Deluxe", 2);
        h2.Display();
        HotelBooking h3 = new HotelBooking(h2);
        h3.Display();
    }
}
