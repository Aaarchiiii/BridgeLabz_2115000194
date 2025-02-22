package D_22_02_25.Regex;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ValidateHexColor {
    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }
    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500"));
        System.out.println(isValidHexColor("#ff4500"));
        System.out.println(isValidHexColor("#123"));
        System.out.println(isValidHexColor("FFA500"));
        System.out.println(isValidHexColor("#ZZZZZZ"));
    }
}
class HexColorValidatorTest {
    @Test
    void testValidHexColors() {
        assertTrue(ValidateHexColor.isValidHexColor("#FFA500"));
        assertTrue(ValidateHexColor.isValidHexColor("#ff4500"));
        assertTrue(ValidateHexColor.isValidHexColor("#000000"));
        assertTrue(ValidateHexColor.isValidHexColor("#FFFFFF"));
    }
    @Test
    void testInvalidHexColors() {
        assertFalse(ValidateHexColor.isValidHexColor("#123"));
        assertFalse(ValidateHexColor.isValidHexColor("FFA500"));
        assertFalse(ValidateHexColor.isValidHexColor("#ZZZZZZ"));
        assertFalse(ValidateHexColor.isValidHexColor("#A1B2C"));
        assertFalse(ValidateHexColor.isValidHexColor("#1234567"));
    }
}
