package D_25_02_25;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/students.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String[]> duplicates = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] header = reader.readNext();
            String[] row;
            while ((row = reader.readNext()) != null) {
                String id = row[0];
                if (!uniqueIds.add(id)) {
                    duplicates.add(row);
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        if (duplicates.isEmpty()) {
            System.out.println("No duplicate records found.");
        } else {
            System.out.println("Duplicate Records:");
            for (String[] duplicate : duplicates) {
                System.out.println(Arrays.toString(duplicate));
            }
        }
    }
}
