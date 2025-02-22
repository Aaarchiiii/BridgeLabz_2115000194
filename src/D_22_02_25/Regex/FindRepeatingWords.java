package D_22_02_25.Regex;

import java.util.*;
import java.util.regex.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class FindRepeatingWords {
    public static Set<String> findRepeats(String text) {
        Set<String> words = new HashSet<>();
        Set<String> repeatedWords = new HashSet<>();
        Matcher matcher = Pattern.compile("\\b(\\w+)\\b").matcher(text);
        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (!words.add(word)) {
                repeatedWords.add(word);
            }
        }
        return repeatedWords;
    }
    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        Set<String> repeats = findRepeats(text);
        System.out.println(String.join(", ", repeats));
    }
}
class FindRepeatingWordsTest {
    @Test
    void testFindRepeats() {
        assertEquals(Set.of("is", "repeated"), FindRepeatingWords.findRepeats("This is is a repeated repeated word test."));
        assertEquals(Set.of("word"), FindRepeatingWords.findRepeats("Word word test example."));
        assertEquals(Collections.emptySet(), FindRepeatingWords.findRepeats("No duplicates here."));
    }
}
