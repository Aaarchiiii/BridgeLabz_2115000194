package D_22_02_25.Regex;

import java.util.regex.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExtractProgrammingLanguage {
    public static List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        List<String> knownLanguages = Arrays.asList("Java", "Python", "JavaScript", "C", "C++", "C#", "Go", "Ruby", "Swift", "Kotlin", "PHP", "Rust", "Perl", "R", "TypeScript", "Scala", "Dart");
        for (String lang : knownLanguages) {
            if (text.matches(".*\\b" + lang + "\\b.*")) {
                languages.add(lang);
            }
        }
        return languages;
    }
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        List<String> languages = extractLanguages(text);
        System.out.println(String.join(", ", languages));
    }
}
class ExtractProgrammingLanguageTest {
    @Test
    void testExtractLanguages() {
        assertEquals(Arrays.asList("Java", "Python", "JavaScript", "Go"),
                ExtractProgrammingLanguage.extractLanguages("I love Java, Python, and JavaScript, but I haven't tried Go yet."));

        assertEquals(Arrays.asList("C", "C++", "Rust"),
                ExtractProgrammingLanguage.extractLanguages("C and C++ are great, but Rust is the future."));

        assertEquals(Collections.emptyList(),
                ExtractProgrammingLanguage.extractLanguages("I enjoy painting and music."));
    }
}
