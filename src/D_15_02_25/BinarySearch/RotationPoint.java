package D_15_02_25.BinarySearch;

public class RotationPoint {
    public static int Find(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] rotatedArray = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int rotationIndex = Find(rotatedArray);
        System.out.println("The rotation point index is: " + rotationIndex);
        System.out.println("The smallest element is: " + rotatedArray[rotationIndex]);
    }
}
