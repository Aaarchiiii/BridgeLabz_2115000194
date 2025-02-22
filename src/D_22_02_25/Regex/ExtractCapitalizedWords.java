package D_22_02_25.Regex;

import java.util.regex.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExtractCapitalizedWords {
    public static List<String> extractWords(String text) {
        List<String> words = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b[A-Z][a-z]*\\b").matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        List<String> words = extractWords(text);
        System.out.println(String.join(", ", words));
    }
}
class ExtractCapitalizedWordsTest {
    @Test
    void testExtractWords() {
        List<String> result = ExtractCapitalizedWords.extractWords("The Eiffel Tower is in Paris and the Statue of Liberty is in New York.");
        assertEquals(Arrays.asList("Eiffel", "Tower", "Paris", "Statue", "Liberty", "New", "York"), result);
        result = ExtractCapitalizedWords.extractWords("No Capitalized words here.");
        assertTrue(result.isEmpty());
        result = ExtractCapitalizedWords.extractWords("Hello World, Welcome To Java Programming.");
        assertEquals(Arrays.asList("Hello", "World", "Welcome", "To", "Java", "Programming"), result);
    }
}
