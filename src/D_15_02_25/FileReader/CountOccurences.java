package D_15_02_25.FileReader;

import java.io.*;
public class CountOccurences {
    public static int countWord(String fileName, String targetWord) {
        int count = 0;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return count;
    }
    public static void main(String[] args) {
        String fileName = "read.txt";
        String targetWord = "hello";
        int occurrences = countWord(fileName, targetWord);
        System.out.println("The word \"" + targetWord + "\" appears " + occurrences + " times in the file.");
    }
}
