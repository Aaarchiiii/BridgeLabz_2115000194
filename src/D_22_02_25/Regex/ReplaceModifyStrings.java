package D_22_02_25.Regex;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class ReplaceModifyStrings {
    public static String replaceMultipleSpaces(String text) {
        return text.replaceAll("\\s+", " ");
    }
    public static void main(String[] args) {
        String text = "This   is  an   example   with    multiple    spaces.";
        System.out.println(replaceMultipleSpaces(text));
    }
}
class ReplaceModifyStringsTest {
    @Test
    void testReplaceMultipleSpaces() {
        assertEquals("This is an example with multiple spaces.", ReplaceModifyStrings.replaceMultipleSpaces("This   is  an   example   with    multiple    spaces."));
        assertEquals("Hello World!", ReplaceModifyStrings.replaceMultipleSpaces("Hello    World!"));
        assertEquals("No extra spaces", ReplaceModifyStrings.replaceMultipleSpaces("No extra spaces"));
        assertEquals(" Leading and trailing ", ReplaceModifyStrings.replaceMultipleSpaces("   Leading   and   trailing   "));
    }
}
