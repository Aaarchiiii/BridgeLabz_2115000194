package D_20_02_25;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
public class ByteArrayStream {
    public static void main(String[] args) {
        String input = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\input.jpg";
        String output = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\output.jpg";
        try {
            byte[] imageBytes = convertImageToByteArray(input);
            writeByteArrayToImage(imageBytes, output);
            if (verifyFiles(input, output)) {
                System.out.println("The files are identical.");
            } else {
                System.out.println("The files are not identical.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static byte[] convertImageToByteArray(String imagePath) throws IOException {
        File file = new File(imagePath);
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(file.toPath(), baos);
            return baos.toByteArray();
        }
    }
    public static void writeByteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
    public static boolean verifyFiles(String filePath1, String filePath2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(new File(filePath1).toPath());
        byte[] file2Bytes = Files.readAllBytes(new File(filePath2).toPath());
        return Arrays.equals(file1Bytes, file2Bytes);
    }
}
