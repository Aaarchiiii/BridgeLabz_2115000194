package D_25_02_25;

import org.apache.commons.csv.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
public class ValidateCSV {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{10}$");
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees.csv");
        try {
            String csvContent = Files.readString(filePath, StandardCharsets.UTF_8);
            try (CSVParser csvParser = CSVParser.parse(csvContent, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                boolean hasErrors = false;
                for (CSVRecord record : csvParser) {
                    String email = record.get("Email");
                    String phone = record.get("Phone Number");
                    boolean isEmailValid = EMAIL_PATTERN.matcher(email).matches();
                    boolean isPhoneValid = PHONE_PATTERN.matcher(phone).matches();
                    if (!isEmailValid || !isPhoneValid) {
                        hasErrors = true;
                        System.out.println("Invalid Record Found: " + record);
                        if (!isEmailValid) {
                            System.out.println("Error: " + email);
                        }
                        if (!isPhoneValid) {
                            System.out.println(" → Error: Invalid Phone Number - " + phone);
                        }
                    }
                }
                if (!hasErrors) {
                    System.out.println("All records are valid!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
