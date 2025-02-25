package D_25_02_25;

import org.apache.commons.csv.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
public class UpdateCSV {
    public static void main(String[] args) {
        Path inputFile = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees.csv");
        Path outputFile = Path.of("C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees_updated.csv");
        List<CSVRecord> records;
        List<String[]> updatedRecords = new ArrayList<>();
        try {
            String csvContent = Files.readString(inputFile, StandardCharsets.UTF_8);
            try (CSVParser csvParser = CSVParser.parse(csvContent, CSVFormat.DEFAULT.withFirstRecordAsHeader())) {
                records = csvParser.getRecords();
                updatedRecords.add(new String[]{"ID", "Name", "Department", "Salary"});
                for (CSVRecord record : records) {
                    String id = record.get("ID");
                    String name = record.get("Name");
                    String department = record.get("Department");
                    double salary = Double.parseDouble(record.get("Salary"));
                    if (department.equalsIgnoreCase("IT")) {
                        salary *= 1.10;
                    }
                    updatedRecords.add(new String[]{id, name, department, String.format("%.2f", salary)});
                }
            }
            try (CSVPrinter csvPrinter = new CSVPrinter(new FileWriter(outputFile.toFile()),
                    CSVFormat.DEFAULT.withHeader("ID", "Name", "Department", "Salary"))) {
                for (int i = 1; i < updatedRecords.size(); i++) {
                    csvPrinter.printRecord((Object[]) updatedRecords.get(i));
                }
                System.out.println("CSV file updated successfully: " + outputFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
