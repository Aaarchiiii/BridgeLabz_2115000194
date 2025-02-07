package D_07_02_25;
class Vehicle{
    int maxSpeed;
    String fuelType;
    public Vehicle(int maxSpeed, String fuelType){
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    public void displayInfo(){
        System.out.println("Maximum Speed "+maxSpeed+" Fuel Type: "+fuelType);
    }
}
class Car extends Vehicle{
    int seatCapacity;
    public Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Car, Seat Capacity: "+seatCapacity);
    }
}
class Truck extends Vehicle{
    int loadCapacity;
    public Truck(int maxSpeed, String fuelType, int loadCapacity){
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Truck, Load Capacity: "+loadCapacity);
    }
}
class MotorCycle extends Vehicle{
    public MotorCycle(int maxSpeed, String fuelType){
        super(maxSpeed, fuelType);
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Motorcycle");
    }
}
public class VehicleSystem {
    public static void main(String[] args){
        Vehicle[] vehicles = {
                new Car(180, "Petrol", 5),
                new Truck(120, "Diesel", 10),
                new MotorCycle(200, "Petrol")
        };
        System.out.println("Vehicle Details:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }
}
