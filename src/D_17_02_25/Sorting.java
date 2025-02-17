package D_17_02_25;

import java.util.*;
public class Sorting {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, mid + 1, rightArray, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int size : datasetSizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10);
            }
            int[] dataBubble = Arrays.copyOf(data, data.length);
            int[] dataMerge = Arrays.copyOf(data, data.length);
            int[] dataQuick = Arrays.copyOf(data, data.length);
            long startTime = System.nanoTime();
            bubbleSort(dataBubble);
            long endTime = System.nanoTime();
            long bubbleTime = endTime - startTime;
            startTime = System.nanoTime();
            mergeSort(dataMerge, 0, dataMerge.length - 1);
            endTime = System.nanoTime();
            long mergeTime = endTime - startTime;
            startTime = System.nanoTime();
            quickSort(dataQuick, 0, dataQuick.length - 1);
            endTime = System.nanoTime();
            long quickTime = endTime - startTime;
            System.out.println("Dataset Size: " + size);
            System.out.println("Bubble Sort Time: " + bubbleTime / 1e6 + " ms");
            System.out.println("Merge Sort Time: " + mergeTime / 1e6 + " ms");
            System.out.println("Quick Sort Time: " + quickTime / 1e6 + " ms");
        }
    }
}
