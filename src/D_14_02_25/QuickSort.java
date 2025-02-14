package D_14_02_25;

import java.util.Scanner;

public class QuickSort {
    public static void Sort(double[] prices, int low, int high){
        if(low<high){
            int mid = Partition(prices, low, high);
            Sort(prices, low, mid-1);
            Sort(prices, mid+1, high);
        }
    }
    public static int Partition(double[] prices, int low, int high) {
        double pivot = prices[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        return i + 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of products");
        int n = sc.nextInt();
        double[] prices = new double[n];
        System.out.println("Enter price");
        for(int i=0; i<n; i++){
            prices[i] = sc.nextDouble();
        }
        System.out.println("Before Sorting");
        for(int i=0; i<n; i++){
            System.out.print(prices[i]+" ");
        }
        System.out.println();
        Sort(prices, 0, n-1);
        System.out.println("After Sorting");
        for(int i=0; i<n; i++){
            System.out.print(prices[i]+" ");
        }
    }
}
