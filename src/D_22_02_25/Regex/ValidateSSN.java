package D_22_02_25.Regex;

import java.util.regex.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ValidateSSN {
    public static boolean isValidSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }
    public static void main(String[] args) {
        String ssn1 = "123-45-6789";
        String ssn2 = "123456789";
        System.out.println(ssn1 + " is " + (isValidSSN(ssn1) ? "valid" : "invalid"));
        System.out.println(ssn2 + " is " + (isValidSSN(ssn2) ? "valid" : "invalid"));
    }
}
class ValidateSSNTest {
    @Test
    void testValidSSNs() {
        assertTrue(ValidateSSN.isValidSSN("123-45-6789"));
        assertTrue(ValidateSSN.isValidSSN("987-65-4321"));
    }
    @Test
    void testInvalidSSNs() {
        assertFalse(ValidateSSN.isValidSSN("123456789"));
        assertFalse(ValidateSSN.isValidSSN("12-345-6789"));
        assertFalse(ValidateSSN.isValidSSN("123-456-789"));
        assertFalse(ValidateSSN.isValidSSN("abc-de-ghij"));
    }
}
