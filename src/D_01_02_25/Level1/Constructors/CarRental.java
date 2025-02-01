package D_01_02_25.Level1.Constructors;

public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double rate = 50.0;
    public CarRental(){
        this.customerName = "";
        this.carModel = "";
        this.rentalDays = 0;
    }
    public CarRental(String customerName, String carModel, int rentalDays){
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    public double TotalCost(){
        return rentalDays*rate;
    }
    public void Display(){
        System.out.println("Customer Name: "+customerName);
        System.out.println("Car Model: "+carModel);
        System.out.println("Rental Days: "+rentalDays);
        System.out.println("Total cost: "+TotalCost());
    }
    public static void main(String[] args){
        CarRental c1 = new CarRental();
        c1.Display();
        CarRental c2 = new CarRental("Archi", "Baleno", 2);
        c2.Display();
    }
}
