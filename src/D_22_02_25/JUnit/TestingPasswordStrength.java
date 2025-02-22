package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestingPasswordStrength {
    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }
    @Test
    void testValidPasswords() {
        assertTrue(isValidPassword("StrongPass1"));
        assertTrue(isValidPassword("HelloWorld9"));
        assertTrue(isValidPassword("Secure123A"));
    }
    @Test
    void testInvalidPasswords() {
        assertFalse(isValidPassword("short1"));
        assertFalse(isValidPassword("alllowercase1"));
        assertFalse(isValidPassword("NOLOWERCASE1"));
        assertFalse(isValidPassword("NoDigitsHere"));
    }
}
