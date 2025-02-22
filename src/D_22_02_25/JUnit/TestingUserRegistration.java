package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestingUserRegistration {
    static class UserRegistration {
        public void registerUser(String username, String email, String password) {
            if (username == null || username.length() < 5) {
                throw new IllegalArgumentException("Invalid username: must be at least 5 characters long.");
            }
            if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                throw new IllegalArgumentException("Invalid email format.");
            }
            if (!password.matches("^(?=.*[A-Z])(?=.*\\d).{8,}$")) {
                throw new IllegalArgumentException("Invalid password: must be at least 8 characters long, contain one uppercase letter and one number.");
            }
        }
    }
    private final UserRegistration userRegistration = new UserRegistration();
    @Test
    void testValidUserRegistration() {
        assertDoesNotThrow(() -> userRegistration.registerUser("validUser", "test@example.com", "StrongPass1"));
    }
    @Test
    void testInvalidUsername() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("usr", "test@example.com", "StrongPass1"));
    }
    @Test
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "invalid-email", "StrongPass1"));
    }
    @Test
    void testInvalidPassword() {
        assertThrows(IllegalArgumentException.class, () -> userRegistration.registerUser("validUser", "test@example.com", "weakpass"));
    }
}
