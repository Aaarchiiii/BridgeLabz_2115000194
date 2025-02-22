package D_22_02_25.Regex;

import java.util.regex.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ValidateIPAddress {
    public static boolean isValidIPAddress(String ip) {
        String regex = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        return ip.matches(regex);
    }
    public static void main(String[] args) {
        System.out.println(isValidIPAddress("192.168.1.1"));
        System.out.println(isValidIPAddress("255.255.255.255"));
        System.out.println(isValidIPAddress("256.100.50.25"));
        System.out.println(isValidIPAddress("192.168.1"));
        System.out.println(isValidIPAddress("abc.def.ghi.jkl"));
    }
}
class ValidateIPAddressTest {
    @Test
    void testValidIPAddresses() {
        assertTrue(ValidateIPAddress.isValidIPAddress("192.168.1.1"));
        assertTrue(ValidateIPAddress.isValidIPAddress("0.0.0.0"));
        assertTrue(ValidateIPAddress.isValidIPAddress("255.255.255.255"));
        assertTrue(ValidateIPAddress.isValidIPAddress("10.0.0.1"));
    }
    @Test
    void testInvalidIPAddresses() {
        assertFalse(ValidateIPAddress.isValidIPAddress("256.100.50.25"));
        assertFalse(ValidateIPAddress.isValidIPAddress("192.168.1"));
        assertFalse(ValidateIPAddress.isValidIPAddress("abc.def.ghi.jkl"));
        assertFalse(ValidateIPAddress.isValidIPAddress("192.168.1.999"));
        assertFalse(ValidateIPAddress.isValidIPAddress("300.400.500.600"));
    }
}
