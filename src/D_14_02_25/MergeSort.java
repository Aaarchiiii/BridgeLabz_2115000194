package D_14_02_25;
import java.util.*;
public class MergeSort {
    public static void Sort(double[] prices, int left, int right){
        if(left<right){
            int mid = left+(right-left)/2;
            Sort(prices, left, mid);
            Sort(prices, mid+1, right);
            Merge(prices, left, mid, right);
        }
    }
    public static void Merge(double[] prices, int left, int mid, int right){
        int n1 = mid-left+1;
        int n2 = right-mid;
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];
        for(int i=0; i<n1; i++){
            leftArray[i] = prices[left+i];
        }
        for(int j=0; j<n2; j++){
            rightArray[j] = prices[mid+1+j];
        }
        int i=0;
        int j=0;
        int k = left;
        while(i<n1 && j<n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while(i<n1){
            prices[k] = leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            prices[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of books");
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
