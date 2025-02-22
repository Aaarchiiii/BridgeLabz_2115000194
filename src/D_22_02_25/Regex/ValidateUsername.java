package D_22_02_25.Regex;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ValidateUsername{
    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z][a-zA-Z0-9_]{4,14}$");
    }
}
class UsernameValidatorTest {
    @Test
    void testValidUsernames() {
        assertTrue(ValidateUsername.isValidUsername("user_123"));
        assertTrue(ValidateUsername.isValidUsername("John_Doe"));
        assertTrue(ValidateUsername.isValidUsername("Alice2023"));
    }
    @Test
    void testInvalidUsernames() {
        assertFalse(ValidateUsername.isValidUsername("123user"));
        assertFalse(ValidateUsername.isValidUsername("us"));
        assertFalse(ValidateUsername.isValidUsername("verylongusername123"));
        assertFalse(ValidateUsername.isValidUsername("user@name"));
        assertFalse(ValidateUsername.isValidUsername("_username"));
    }
}
