package D_04_02_25;

public class Vehicle {
    static int registrationFee = 2500;
    private String ownerName;
    final private int registrationNumber;
    private String vehicleType;
    public Vehicle(String ownerName, int registrationNumber, String vehicleType){
        this.ownerName = ownerName;
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }
    static int updateRegistrationFee(int r){
        registrationFee = r;
        return r;
    }
    public void Display(){
        System.out.println("Name: "+ownerName);
        System.out.println("Registration Number: "+registrationNumber);
        System.out.println("Vehicle Type: "+vehicleType);
    }
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Ram", 1011, "Car");
        System.out.println(v1 instanceof Vehicle);
        System.out.println("Registration Fee: "+registrationFee);
        v1.updateRegistrationFee(3000);
        System.out.println("Updated Registration Fee: "+registrationFee);
        v1.Display();

    }
}