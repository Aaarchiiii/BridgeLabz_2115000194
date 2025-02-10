package D_10_02_25;
import java.util.*;
abstract class Vehicle1{
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    public Vehicle1(String vehicleNumber, String type, double rentalRate){
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    public String getVehicleNumber(){
        return vehicleNumber;
    }
    public String getType(){
        return type;
    }
    public double getRentalRate(){
        return rentalRate;
    }
    public void setRentalRate(double rentalRate){
        this.rentalRate = rentalRate;
    }
    public abstract double calculateRentalCost(int days);
    public void displayDetails(){
        System.out.println("Vehicle Number: "+vehicleNumber);
        System.out.println("Vehicle Type: "+type);
        System.out.println("Rental Rate: "+rentalRate);
    }
}
interface Insurable{
    double calculateInsurance();
    String getInsuranceDetails();
}
class Car1 extends Vehicle1 implements Insurable{
    private static final double INSURANCE_RATE = 0.02;
    public Car1(String vehicleNumber, double rentalRate){
        super(vehicleNumber,"Car", rentalRate);
    }
    public double calculateRentalCost(int days){
        return  getRentalRate()*days;
    }

    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1)*INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Rate: "+(INSURANCE_RATE*100);
    }
}
class Bike1 extends Vehicle1 implements Insurable{
    private static final double INSURANCE_RATE = 0.01;
    public Bike1(String vehicleNumber, double rentalRate){
        super(vehicleNumber,"Bike", rentalRate);
    }
    public double calculateRentalCost(int days){
        return  getRentalRate()*days;
    }
    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1)*INSURANCE_RATE;
    }
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Rate: "+(INSURANCE_RATE*100);
    }
}
class Truck extends Vehicle1 implements Insurable{
    private static final double INSURANCE_RATE = 0.05;
    public Truck(String vehicleNumber, double rentalRate){
        super(vehicleNumber,"Truck", rentalRate);
    }
    public double calculateRentalCost(int days){
        return  getRentalRate()*days;
    }

    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1)*INSURANCE_RATE;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Rate: "+(INSURANCE_RATE*100);
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args){
        ArrayList<Vehicle1> vehicles = new ArrayList<>();
        Car1 car = new Car1("CAR123", 50);
        Bike1 bike = new Bike1("BIKE123", 20);
        Truck truck = new Truck("TRUCK123", 100);
        vehicles.add(car);
        vehicles.add(bike);
        vehicles.add(truck);
        int rentalDays = 5;
        for(Vehicle1 vehicle:vehicles){
            vehicle.displayDetails();
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            double insuranceCost = 0;
            if(vehicle instanceof Insurable){
                Insurable insurable = (Insurable) vehicle;
                insuranceCost = insurable.calculateInsurance();
                System.out.println(insurable.getInsuranceDetails());
            }
            System.out.println("Rental Cost: "+rentalCost);
            System.out.println("Insurance Cost: "+insuranceCost);
        }
    }
}
