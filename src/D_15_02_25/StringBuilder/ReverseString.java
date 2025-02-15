package D_15_02_25.StringBuilder;

public class ReverseString {
    public static String Reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            result.append(sb.charAt(i));
        }
        String output = "";
        for (int i = 0; i < result.length(); i++) {
            output += result.charAt(i);
        }
        return output;
    }
    public static void main(String[] args) {
        String input = "hello";
        String reversed = Reverse(input);
        System.out.println("Original String: " + input);
        System.out.println("Reversed String: " + reversed);
    }
}
