package D_20_02_25;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class CountWords {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Dell\\IdeaProjects\\BridgeLabzAssignment\\src\\D_20_02_25\\read.txt";
        Map<String, Integer> wordCountMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().replaceAll("[^a-zA-Z ]", "").split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Map.Entry<String, Integer>> sortedWords = wordCountMap.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("Top 5 most frequently occurring words:");
        for (Map.Entry<String, Integer> entry : sortedWords) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}