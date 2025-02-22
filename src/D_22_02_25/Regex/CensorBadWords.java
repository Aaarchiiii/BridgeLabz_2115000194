package D_22_02_25.Regex;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class CensorBadWords {
    public static String censorWords(String text, List<String> badWords) {
        for (String word : badWords) {
            text = text.replaceAll("\\b" + word + "\\b", "****");
        }
        return text;
    }
    public static void main(String[] args) {
        String text = "This is a damn bad example with some stupid words.";
        List<String> badWords = Arrays.asList("damn", "stupid");
        System.out.println(censorWords(text, badWords));
    }
}
class CensorBadWordsTest {
    @Test
    void testCensorWords() {
        List<String> badWords = Arrays.asList("damn", "stupid");
        assertEquals("This is a **** bad example with some **** words.", CensorBadWords.censorWords("This is a damn bad example with some stupid words.", badWords));
        assertEquals("No bad words here.", CensorBadWords.censorWords("No bad words here.", badWords));
        assertEquals("**** this!", CensorBadWords.censorWords("Damn this!", badWords));
    }
}
