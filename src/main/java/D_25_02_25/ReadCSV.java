package D_25_02_25;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class ReadCSV {
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/students.csv");
        try {
            String csvContent = Files.readString(filePath, StandardCharsets.UTF_8);
            try (CSVParser csvParser = CSVParser.parse(csvContent, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                System.out.println("Student Details:");
                for (CSVRecord record : csvParser) {
                    System.out.println("ID: " + record.get("ID"));
                    System.out.println("Name: " + record.get("Name"));
                    System.out.println("Age: " + record.get("Age"));
                    System.out.println("Marks: " + record.get("Marks"));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
