package D_22_02_25.Regex;

import java.util.regex.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ExtractCurrencyValues {
    public static List<String> extractValues(String text) {
        List<String> values = new ArrayList<>();
        Matcher matcher = Pattern.compile("\\$?\\d+\\.\\d{2}").matcher(text);
        while (matcher.find()) {
            values.add(matcher.group());
        }
        return values;
    }
    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is 10.50.";
        List<String> values = extractValues(text);
        System.out.println(String.join(", ", values));
    }
}
class ExtractCurrencyValuesTest {
    @Test
    void testExtractValues() {
        assertEquals(Arrays.asList("$45.99", "10.50"),
                ExtractCurrencyValues.extractValues("The price is $45.99, and the discount is 10.50."));

        assertEquals(Arrays.asList("$100.00", "$5.75", "3.99"),
                ExtractCurrencyValues.extractValues("Total is $100.00, tax is $5.75, and the fee is 3.99."));

        assertEquals(Collections.emptyList(),
                ExtractCurrencyValues.extractValues("No prices mentioned here."));
    }
}
