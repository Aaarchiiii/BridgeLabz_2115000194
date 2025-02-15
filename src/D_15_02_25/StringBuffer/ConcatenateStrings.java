package D_15_02_25.StringBuffer;

public class ConcatenateStrings {
    public static String Concatenation(String[] strings) {
        StringBuffer sb = new StringBuffer();
        for (String str : strings) {
            sb.append(str);
        }
        String result = "";
        for (int i = 0; i < sb.length(); i++) {
            result += sb.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!"};
        String result = Concatenation(input);
        System.out.println("Concatenated String: " + result);
    }
}
