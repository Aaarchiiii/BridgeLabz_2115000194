package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestingExceptionHandling {
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return a / b;
    }
    public static void main(String[] args) {
        System.out.println(divide(10, 2));
        System.out.println(divide(9, 3));
        try {
            System.out.println(divide(5, 0));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
class TestingExceptionHandlingTest {
    @Test
    void testValidDivision() {
        assertEquals(5, TestingExceptionHandling.divide(10, 2));
        assertEquals(3, TestingExceptionHandling.divide(9, 3));
    }
    @Test
    void testDivisionByZeroException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> TestingExceptionHandling.divide(5, 0));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }
}
