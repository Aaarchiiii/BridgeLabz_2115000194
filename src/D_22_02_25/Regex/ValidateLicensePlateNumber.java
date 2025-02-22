package D_22_02_25.Regex;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidateLicensePlateNumber {
    public static boolean isValidLicensePlate(String plate) {
        return plate.matches("^[A-Z]{2}\\d{4}$");
    }
    public static void main(String[] args) {
        // Example test cases
        System.out.println(isValidLicensePlate("AB1234"));
        System.out.println(isValidLicensePlate("A12345"));
        System.out.println(isValidLicensePlate("XY5678"));
        System.out.println(isValidLicensePlate("ABC123"));
        System.out.println(isValidLicensePlate("AB12A4"));
    }
}
class LicensePlateValidatorTest {
    @Test
    void testValidLicensePlates() {
        assertTrue(ValidateLicensePlateNumber.isValidLicensePlate("AB1234"));
        assertTrue(ValidateLicensePlateNumber.isValidLicensePlate("XY5678"));
        assertTrue(ValidateLicensePlateNumber.isValidLicensePlate("CD9876"));
    }
    @Test
    void testInvalidLicensePlates() {
        assertFalse(ValidateLicensePlateNumber.isValidLicensePlate("A12345"));
        assertFalse(ValidateLicensePlateNumber.isValidLicensePlate("ABC123"));
        assertFalse(ValidateLicensePlateNumber.isValidLicensePlate("AB12A4"));
        assertFalse(ValidateLicensePlateNumber.isValidLicensePlate("123456"));
        assertFalse(ValidateLicensePlateNumber.isValidLicensePlate("AB123"));
    }
}
