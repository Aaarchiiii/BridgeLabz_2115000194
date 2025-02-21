package D_21_02_25;

import java.io.*;
public class CheckedException {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_21_02_25\\read.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
