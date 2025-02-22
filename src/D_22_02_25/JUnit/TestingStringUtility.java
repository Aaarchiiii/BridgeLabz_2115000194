package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestingStringUtility {
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    public static boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }
    public static void main(String[] args) {
        System.out.println(reverse("hello"));
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("hello"));
        System.out.println(toUpperCase("hello"));
    }
}
class TestingStringUtilityTest {
    @Test
    void testReverse() {
        assertEquals("olleh", TestingStringUtility.reverse("hello"));
        assertEquals("racecar", TestingStringUtility.reverse("racecar"));
        assertEquals("", TestingStringUtility.reverse(""));
    }
    @Test
    void testIsPalindrome() {
        assertTrue(TestingStringUtility.isPalindrome("madam"));
        assertTrue(TestingStringUtility.isPalindrome("Racecar"));
        assertFalse(TestingStringUtility.isPalindrome("hello"));
    }
    @Test
    void testToUpperCase() {
        assertEquals("HELLO", TestingStringUtility.toUpperCase("hello"));
        assertEquals("JAVA", TestingStringUtility.toUpperCase("java"));
        assertEquals("TEST", TestingStringUtility.toUpperCase("TEST"));
    }
}
