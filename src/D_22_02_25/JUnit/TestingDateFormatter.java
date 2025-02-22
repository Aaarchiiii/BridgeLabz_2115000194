package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TestingDateFormatter {
    public static String formatDate(String inputDate) throws ParseException {
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = inputFormat.parse(inputDate);
        return outputFormat.format(date);
    }
    @Test
    void testValidDateFormat() throws ParseException {
        assertEquals("25-12-2023", formatDate("2023-12-25"));
        assertEquals("01-01-2024", formatDate("2024-01-01"));
        assertEquals("15-08-2022", formatDate("2022-08-15"));
    }
    @Test
    void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> formatDate("15/08/2022"));
        assertThrows(ParseException.class, () -> formatDate("2022.08.15"));
        assertThrows(ParseException.class, () -> formatDate("08-15-2022"));
    }
}
