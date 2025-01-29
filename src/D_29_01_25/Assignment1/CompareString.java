package D_29_01_25.Assignment1;

import java.util.Scanner;
public class CompareString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two strings : ");
        String str1 = input.nextLine().trim();
        String str2 = input.nextLine().trim();
        int str1Length = str1.length(), str2Length = str2.length();
        if (str1Length > str2Length) {
            int index = 0;
            for (char i : str2.toCharArray()) {
                char a = str1.charAt(index);
                if (a > i) {
                    System.out.println(str2 + " comes before " + str1 + " in lexicographical order ");
                    break;
                } else if (a < i) {
                    System.out.println(str1 + " comes before " + str2 + " in lexicographical order ");
                    break;
                } else {
                    index++;
                }
            }
        } else if (str1Length < str2Length) {
            int index = 0;
            for (char i : str1.toCharArray()) {
                char a = str2.charAt(index);
                if (a > i) {
                    System.out.println(str1 + " comes before " + str2 + " in lexicographical order ");
                    break;
                } else if (a < i) {
                    System.out.println(str2 + " comes before " + str1 + " in lexicographical order ");
                    break;
                } else {
                    index++;
                }
            }
        } else {
            int index = 0;
            for (char i : str2.toCharArray()) {
                char a = str1.charAt(index);
                if (a > i) {
                    System.out.println(str2 + " comes before " + str1 + " in lexicographical order ");
                    break;
                } else if (a < i) {
                    System.out.println(str1 + " comes before " + str2 + " in lexicographical order ");
                    break;
                } else {
                    index++;
                }
            }
            if (index == str2Length) {
                System.out.println("Both Strings are equal in lexicographical order ");
            }
        }
    }
}