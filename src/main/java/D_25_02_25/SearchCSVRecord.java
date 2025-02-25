package D_25_02_25;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class SearchCSVRecord {
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees.csv");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter Employee Name to Search: ");
            String searchName = sc.nextLine().trim();
            String csvContent = Files.readString(filePath, StandardCharsets.UTF_8);
            try (CSVParser csvParser = CSVParser.parse(csvContent, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                boolean found = false;
                for (CSVRecord record : csvParser) {
                    if (record.get("Name").equalsIgnoreCase(searchName)) {
                        System.out.println("Employee Found: ");
                        System.out.println("Department: " + record.get("Department"));
                        System.out.println("Salary: " + record.get("Salary"));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Employee not found.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
