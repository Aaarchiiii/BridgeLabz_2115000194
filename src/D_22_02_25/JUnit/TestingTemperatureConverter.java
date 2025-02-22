package D_22_02_25.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestingTemperatureConverter {
    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
    @Test
    void testCelsiusToFahrenheit() {
        assertEquals(32.0, celsiusToFahrenheit(0), 0.01);
        assertEquals(98.6, celsiusToFahrenheit(37), 0.01);
        assertEquals(212.0, celsiusToFahrenheit(100), 0.01);
    }
    @Test
    void testFahrenheitToCelsius() {
        assertEquals(0.0, fahrenheitToCelsius(32), 0.01);
        assertEquals(37.0, fahrenheitToCelsius(98.6), 0.01);
        assertEquals(100.0, fahrenheitToCelsius(212), 0.01);
    }
}
