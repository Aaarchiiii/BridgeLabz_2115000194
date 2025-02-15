package D_15_02_25.ChallengeProblem;

import java.io.*;
import java.util.StringTokenizer;
public class Compare {
    public static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < 1_000_000; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static void testFileReader(String filePath) {
        long start = System.nanoTime();
        int wordCount = 0;
        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("FileReader Word Count: " + wordCount);
        System.out.println("FileReader Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static void testInputStreamReader(String filePath) {
        long start = System.nanoTime();
        int wordCount = 0;
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                wordCount += tokenizer.countTokens();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        System.out.println("InputStreamReader Word Count: " + wordCount);
        System.out.println("InputStreamReader Time: " + (end - start) / 1_000_000 + " ms");
    }
    public static void main(String[] args) {
        testStringBuilder();
        testStringBuffer();
        String filePath = "read.txt";
        testFileReader(filePath);
        testInputStreamReader(filePath);
    }
}
