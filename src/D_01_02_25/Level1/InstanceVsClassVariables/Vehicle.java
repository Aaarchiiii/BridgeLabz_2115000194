package D_01_02_25.Level1.InstanceVsClassVariables;

public class Vehicle {
    private String ownerName;
    private String vehicleType;
    private static int registrationFee = 2000;
    public Vehicle(){
        this.ownerName = "";
        this.vehicleType = "";
    }
    public Vehicle(String ownerName, String vehicleType){
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    public void displayVehicleDetails(){
        System.out.println("Owner Name: "+ownerName);
        System.out.println("Vehicle Type: "+vehicleType);
        System.out.println("Registration Fee: "+registrationFee);
    }
    public static void updateRegistrationFee(int newRegistrationFee){
        registrationFee = newRegistrationFee;
    }
    public static void main(String[] args){
        Vehicle v1 = new Vehicle();
        v1.displayVehicleDetails();
        Vehicle v2 = new Vehicle("Ram", "Car");
        Vehicle v3 = new Vehicle("Shyam", "Bus");
        v2.displayVehicleDetails();
        v3.displayVehicleDetails();
        Vehicle.updateRegistrationFee(3000);
        System.out.println("After updation");
        v2.displayVehicleDetails();
        v3.displayVehicleDetails();
    }
}
