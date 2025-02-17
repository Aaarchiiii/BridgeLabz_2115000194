package D_17_02_25;

import java.io.*;
public class LargeFileReadingEfficiency {
    public static void main(String[] args) {
        String filePath = "read.txt";
        System.out.println("Reading using FileReader:");
        long startTime = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            while (fileReader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        System.out.println("FileReader Time: " + (endTime - startTime) / 1e6 + " ms");
        System.out.println("Reading using InputStreamReader:");
        startTime = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            while (inputStreamReader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime = System.nanoTime();
        System.out.println("InputStreamReader Time: " + (endTime - startTime) / 1e6 + " ms");
    }
}
