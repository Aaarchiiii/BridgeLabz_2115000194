package D_21_02_25;

import java.io.*;
public class TryWithResources {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_21_02_25\\read.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                System.out.println("First line: " + firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }
}
