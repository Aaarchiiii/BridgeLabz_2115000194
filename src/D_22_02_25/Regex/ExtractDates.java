package D_22_02_25.Regex;

import java.util.regex.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExtractDates {
    public static List<String> extractDates(String text) {
        List<String> dates = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\b\\d{2}/\\d{2}/\\d{4}\\b").matcher(text);
        while (matcher.find()) {
            dates.add(matcher.group());
        }
        return dates;
    }
    public static void main(String[] args) {
        String text = "The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.";
        List<String> dates = extractDates(text);
        System.out.println(String.join(", ", dates));
    }
}
class ExtractDatesTest {
    @Test
    void testExtractDates() {
        List<String> result = ExtractDates.extractDates("The events are scheduled for 12/05/2023, 15/08/2024, and 29/02/2020.");
        assertEquals(Arrays.asList("12/05/2023", "15/08/2024", "29/02/2020"), result);
        result = ExtractDates.extractDates("No valid dates here.");
        assertTrue(result.isEmpty());
        result = ExtractDates.extractDates("Important dates: 01/01/2000, 31/12/1999.");
        assertEquals(Arrays.asList("01/01/2000", "31/12/1999"), result);
    }
}
