package D_25_02_25;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class MergeCSVFiles {
    public static void main(String[] args) throws CsvValidationException {
        String file1 = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/students1.csv";
        String file2 = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/students2.csv";
        String outputFile = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/merged_students.csv";
        Map<String, String[]> studentData = new HashMap<>();
        try (CSVReader reader1 = new CSVReader(new FileReader(file1))) {
            String[] header1 = reader1.readNext();
            String[] line;
            while ((line = reader1.readNext()) != null) {
                studentData.put(line[0], line);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        try (CSVReader reader2 = new CSVReader(new FileReader(file2))) {
            String[] header2 = reader2.readNext();
            String[] line;
            while ((line = reader2.readNext()) != null) {
                if (studentData.containsKey(line[0])) {
                    String[] existingData = studentData.get(line[0]);
                    String[] mergedData = {existingData[0], existingData[1], existingData[2], line[1], line[2]};
                    studentData.put(line[0], mergedData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {
            String[] header = {"ID", "Name", "Age", "Marks", "Grade"};
            writer.writeNext(header);
            for (String[] row : studentData.values()) {
                writer.writeNext(row);
            }
            System.out.println("Merged CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
