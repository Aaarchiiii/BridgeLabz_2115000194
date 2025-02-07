package D_07_02_25;
class Device{
    String deviceId;
    String status;
    public Device(String deviceId, String status){
        this.deviceId = deviceId;
        this.status = status;
    }
    public void displayStatus(){
        System.out.println("Device Id "+deviceId+" , Status "+status);
    }
}
class Thermostat extends Device{
    double temperatureSetting;
    public Thermostat(String deviceId, String status, double temperatureSetting){
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }
    public void displayStatus(){
        super.displayStatus();
        System.out.println("Temperature Setting: "+temperatureSetting);
    }
}
public class SmartHome {
    public static void main(String[] args){
        Thermostat thermostat = new Thermostat("H123", "ON", 22.5);
        thermostat.displayStatus();
    }
}
