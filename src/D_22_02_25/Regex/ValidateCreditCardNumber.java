package D_22_02_25.Regex;

import java.util.regex.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ValidateCreditCardNumber {
    public static boolean isValidCreditCard(String cardNumber) {
        return cardNumber.matches("^4\\d{15}$") || cardNumber.matches("^5\\d{15}$");
    }
    public static void main(String[] args) {
        System.out.println(isValidCreditCard("4111111111111111"));
        System.out.println(isValidCreditCard("5111111111111111"));
        System.out.println(isValidCreditCard("6111111111111111"));
        System.out.println(isValidCreditCard("411111111111"));
        System.out.println(isValidCreditCard("abcdef1234567890"));
    }
}
class ValidateCreditCardNumberTest {
    @Test
    void testValidCreditCards() {
        assertTrue(ValidateCreditCardNumber.isValidCreditCard("4111111111111111"));
        assertTrue(ValidateCreditCardNumber.isValidCreditCard("5111111111111111"));
    }
    @Test
    void testInvalidCreditCards() {
        assertFalse(ValidateCreditCardNumber.isValidCreditCard("6111111111111111"));
        assertFalse(ValidateCreditCardNumber.isValidCreditCard("411111111111"));
        assertFalse(ValidateCreditCardNumber.isValidCreditCard("abcdef1234567890"));
        assertFalse(ValidateCreditCardNumber.isValidCreditCard("40000000000000001"));
    }
}
