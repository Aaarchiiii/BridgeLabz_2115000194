package D_14_02_25;

import java.util.Scanner;
public class CountingSort {
    public static void countingSort(int[] ages, int min, int max) {
        int range = max - min + 1;
        int n = ages.length;
        int[] count = new int[range];
        int[] result = new int[n];
        for (int age : ages) {
            count[age - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            result[count[ages[i] - min] - 1] = ages[i];
            count[ages[i] - min]--;
        }
        System.arraycopy(result, 0, ages, 0, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter the student ages:");
        for (int i = 0; i < n; i++) {
            ages[i] = sc.nextInt();
        }
        int min = ages[0], max = ages[0];
        for (int age : ages) {
            if (age < min) min = age;
            if (age > max) max = age;
        }
        System.out.println("Before Sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
        countingSort(ages, min, max);
        System.out.println("After Sorting:");
        for (int age : ages) {
            System.out.print(age + " ");
        }
    }
}
