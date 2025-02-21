package D_20_02_25;

import java.io.*;
public class FilterStreams {
    public static void main(String[] args) {
        String input = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\read.txt";
        String output = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\write.txt";
        try {
            convertFileToLowerCase(input, output);
            System.out.println("Conversion successful.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void convertFileToLowerCase(String input, String output) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
        }
    }
}
