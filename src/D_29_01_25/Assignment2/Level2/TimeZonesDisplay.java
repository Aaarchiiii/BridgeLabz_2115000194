package D_29_01_25.Assignment2.Level2;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class TimeZonesDisplay {
    public static void displayTime(String zone, String label) {
        ZonedDateTime time = ZonedDateTime.now(ZoneId.of(zone));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z");
        System.out.println(label + ": " + time.format(formatter));
    }
    public static void main(String[] args) {
        System.out.println("Current Time in Different Time Zones:");
        displayTime("GMT", "GMT (Greenwich Mean Time)");
        displayTime("Asia/Kolkata", "IST (Indian Standard Time)");
        displayTime("America/Los_Angeles", "PST (Pacific Standard Time)");
    }
}
