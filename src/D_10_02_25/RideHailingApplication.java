package D_10_02_25;
import java.util.*;
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    public String getVehicleId() {
        return vehicleId;
    }
    public String getDriverName() {
        return driverName;
    }
    public double getRatePerKm() {
        return ratePerKm;
    }
    public abstract double calculateFare(double distance);
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: $" + ratePerKm);
    }
}
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}
class Car extends Vehicle implements GPS {
    private String location;
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    public String getCurrentLocation() {
        return location;
    }
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
class Bike extends Vehicle implements GPS {
    private String location;
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    public String getCurrentLocation() {
        return location;
    }
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
class Auto extends Vehicle implements GPS {
    private String location;
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    public String getCurrentLocation() {
        return location;
    }
    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
public class RideHailingApplication {
    public static void main(String[] args) {
        ArrayList<Vehicle> rides = new ArrayList<>();
        Car car1 = new Car("CAR123", "Archi", 10.0);
        Bike bike1 = new Bike("BIKE456", "Mayank", 5.0);
        Auto auto1 = new Auto("AUTO789", "Khushi", 7.0);
        rides.add(car1);
        rides.add(bike1);
        rides.add(auto1);
        double distance = 15.0;
        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + distance + " Km: $" + ride.calculateFare(distance));
            if (ride instanceof GPS) {
                GPS gpsVehicle = (GPS) ride;
                gpsVehicle.updateLocation("Downtown");
                System.out.println("Updated Location: " + gpsVehicle.getCurrentLocation());
            }
        }
    }
}
