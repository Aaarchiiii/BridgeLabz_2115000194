package D_25_02_25;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
public class CountCSVRows {
    public static void main(String[] args) {
        Path filePath = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees.csv");
        try {
            String csvContent = Files.readString(filePath, StandardCharsets.UTF_8);
            try (CSVParser csvParser = CSVParser.parse(csvContent, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                long rowCount = csvParser.getRecords().size();
                System.out.println("Total Records: " + rowCount);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
