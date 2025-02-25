package D_25_02_25;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "C:/Users/Dell/IdeaProjects/BridgeLabzAssignment/src/main/java/D_25_02_25/employees.csv";
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = {"ID", "Name", "Department", "Salary"};
            String[] emp1 = {"101", "Archi", "Engineering", "60000"};
            String[] emp2 = {"102", "Mayank", "HR", "50000"};
            String[] emp3 = {"103", "Neha", "Marketing", "55000"};
            String[] emp4 = {"104", "Naman", "Finance", "62000"};
            String[] emp5 = {"105", "Khushi", "Sales", "58000"};
            writer.writeNext(header);
            writer.writeNext(emp1);
            writer.writeNext(emp2);
            writer.writeNext(emp3);
            writer.writeNext(emp4);
            writer.writeNext(emp5);
            System.out.println("CSV file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
