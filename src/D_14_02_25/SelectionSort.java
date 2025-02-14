package D_14_02_25;

import java.util.Scanner;
public class SelectionSort {
    public static void Sort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = scores[minIndex];
                scores[minIndex] = scores[i];
                scores[i] = temp;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of exams:");
        int n = sc.nextInt();
        int[] scores = new int[n];
        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        System.out.println("Before Sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(scores[i] + " ");
        }
        System.out.println();
        Sort(scores);
        System.out.println("After Sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(scores[i] + " ");
        }
    }
}
