package D_14_02_25;

import java.util.Scanner;
public class HeapSort {
    public static void Sort(int[] salaries) {
        int n = salaries.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(salaries, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            int temp = salaries[0];
            salaries[0] = salaries[i];
            salaries[i] = temp;
            heapify(salaries, i, 0);
        }
    }
    public static void heapify(int[] salaries, int n, int i) {
        int max = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left < n && salaries[left] > salaries[max]) {
            max = left;
        }
        if (right < n && salaries[right] > salaries[max]) {
            max = right;
        }
        if (max != i) {
            int temp = salaries[i];
            salaries[i] = salaries[max];
            salaries[max] = temp;
            heapify(salaries, n, max);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of applicants: ");
        int n = sc.nextInt();
        int[] salaries = new int[n];
        System.out.println("Enter the salary:");
        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextInt();
        }
        System.out.println("Before Sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(salaries[i] + " ");
        }
        System.out.println();
        Sort(salaries);
        System.out.println("After Sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(salaries[i] + " ");
        }
    }
}

