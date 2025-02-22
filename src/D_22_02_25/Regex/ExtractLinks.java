package D_22_02_25.Regex;

import java.util.regex.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExtractLinks {
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\bhttps?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\S*").matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        List<String> links = extractLinks(text);
        System.out.println(String.join(", ", links));
    }
}
class ExtractLinksTest {
    @Test
    void testExtractLinks() {
        List<String> result = ExtractLinks.extractLinks("Visit https://www.google.com and http://example.org for more info.");
        assertEquals(Arrays.asList("https://www.google.com", "http://example.org"), result);
        result = ExtractLinks.extractLinks("No links here.");
        assertTrue(result.isEmpty());
        result = ExtractLinks.extractLinks("Check https://github.com/user/repo and http://my-site.net/page.html.");
        assertEquals(Arrays.asList("https://github.com/user/repo", "http://my-site.net/page.html"), result);
    }
}
