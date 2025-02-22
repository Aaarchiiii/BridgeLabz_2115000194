package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;
public class TestingFileHandling {
    public static void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }
    public static String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
    @Test
    void testWriteAndReadFile() throws IOException {
        String filename = "testFile.txt";
        String content = "Hello, File Handling!";
        writeToFile(filename, content);
        String readContent = readFromFile(filename);
        assertEquals(content, readContent);
        assertTrue(Files.exists(Paths.get(filename)));
        Files.deleteIfExists(Paths.get(filename));
    }
    @Test
    void testFileNotFoundException() {
        assertThrows(IOException.class, () -> readFromFile("nonexistent.txt"));
    }
}
