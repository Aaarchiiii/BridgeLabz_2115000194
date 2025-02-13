package D_13_02_25.HashMapAndHashFunctions;

import java.util.*;
class PairWithSum {
    public static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(target - num)) {
                System.out.println("Pair found: (" + num + ", " + (target - num) + ")");
                return true;
            }
            set.add(num);
        }
        System.out.println("No pair found");
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 1, 5, 9};
        int target = 10;
        hasPair(arr, target);
    }
}