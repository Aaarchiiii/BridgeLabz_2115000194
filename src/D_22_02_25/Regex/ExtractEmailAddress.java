package D_22_02_25.Regex;

import java.util.regex.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExtractEmailAddress {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        Matcher matcher = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }
    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        List<String> emails = extractEmails(text);
        for (String email : emails) {
            System.out.println(email);
        }
    }
}
class ExtractEmailAddressTest {
    @Test
    void testExtractEmails() {
        List<String> result = ExtractEmailAddress.extractEmails("Email me at test@example.com and hello@domain.net");
        assertEquals(Arrays.asList("test@example.com", "hello@domain.net"), result);
        result = ExtractEmailAddress.extractEmails("No emails here!");
        assertTrue(result.isEmpty());
        result = ExtractEmailAddress.extractEmails("Multiple: first@mail.com, second@work.org");
        assertEquals(Arrays.asList("first@mail.com", "second@work.org"), result);
    }
}
