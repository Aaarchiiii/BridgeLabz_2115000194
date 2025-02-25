package D_25_02_25;

import org.apache.commons.csv.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class SortCSV {
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees.csv");
        try {
            String csvContent = Files.readString(filePath, StandardCharsets.UTF_8);
            try (CSVParser csvParser = CSVParser.parse(csvContent, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                List<CSVRecord> sortedRecords = csvParser.getRecords().stream()
                        .sorted(Comparator.comparingDouble(r -> -Double.parseDouble(r.get("Salary"))))
                        .limit(5)
                        .collect(Collectors.toList());
                System.out.println("Top 5 Highest-Paid Employees:");
                for (CSVRecord record : sortedRecords) {
                    System.out.println("ID: " + record.get("ID") + ", Name: " + record.get("Name") +
                            ", Department: " + record.get("Department") + ", Salary: " + record.get("Salary"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
