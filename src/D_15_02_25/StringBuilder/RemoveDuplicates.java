package D_15_02_25.StringBuilder;

import java.util.*;
public class RemoveDuplicates {
    public static String Remove(String input) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> visit = new HashSet<>();
        for (char ch : input.toCharArray()) {
            if (!visit.contains(ch)) {
                sb.append(ch);
                visit.add(ch);
            }
        }
        String result = "";
        for (int i = 0; i < sb.length(); i++) {
            result += sb.charAt(i);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        String input = sc.next();
        String result = Remove(input);
        System.out.println("Original String: " + input);
        System.out.println("String without Duplicates: " + result);
    }
}
