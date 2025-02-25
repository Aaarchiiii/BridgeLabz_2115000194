package D_25_02_25;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/large_students.csv";
        int batchSize = 100;
        int totalRecordsProcessed = 0;
        int batchCount = 0;
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            reader.readNext();
            String[] row;
            while ((row = reader.readNext()) != null) {
                totalRecordsProcessed++;
                batchCount++;
                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecordsProcessed + " records...");
                    batchCount = 0;
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        System.out.println("Total records processed: " + totalRecordsProcessed);
    }
}
