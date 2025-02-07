package D_07_02_25;

class Vehicle_1{
    double maxSpeed;
    String model;
    public Vehicle_1(double maxSpeed, String model){
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    public void displayInfo(){
        System.out.println("Model: " + model);
        System.out.println("Maximum Speed: " + maxSpeed);
    }
}
class ElectricVehicle extends Vehicle_1{
    public ElectricVehicle(double maxSpeed, String model){
        super(maxSpeed, model);
    }
    public void charge(){
        System.out.println("Charging the electric vehicle.");
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Electric");
    }
}
class PetrolVehicle extends Vehicle_1 implements Refuelable{
    public PetrolVehicle(double maxSpeed, String model){
        super(maxSpeed, model);
    }
    public void refuel(){
        System.out.println("Refueling the petrol vehicle.");
    }
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Vehicle Type: Petrol");
    }
}
interface Refuelable{
    void refuel();
}
public class VehicleManagementSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3");
        PetrolVehicle pv = new PetrolVehicle(180, "Toyota Corolla");
        ev.displayInfo();
        ev.charge();
        System.out.println();
        pv.displayInfo();
        pv.refuel();
    }
}

