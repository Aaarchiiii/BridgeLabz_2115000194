package D_25_02_25;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class FilterCSVRecords {
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/students.csv");
        try {
            String csvContent = Files.readString(filePath, StandardCharsets.UTF_8);
            try (CSVParser csvParser = CSVParser.parse(csvContent, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                System.out.println("Students who scored more than 80 marks:");
                for (CSVRecord record : csvParser) {
                    int marks = Integer.parseInt(record.get("Marks"));
                    if (marks > 80) {
                        System.out.println("ID: " + record.get("ID") + ", Name: " + record.get("Name") + ", Marks: " + marks);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
