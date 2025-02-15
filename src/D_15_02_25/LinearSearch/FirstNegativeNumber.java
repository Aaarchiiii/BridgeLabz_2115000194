package D_15_02_25.LinearSearch;

public class FirstNegativeNumber {
    public static int Find(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, -5, 9, -2, 4};
        int index = Find(numbers);
        if (index != -1) {
            System.out.println("First negative number found at index: " + index);
        } else {
            System.out.println("No negative number found in the array.");
        }
    }
}
