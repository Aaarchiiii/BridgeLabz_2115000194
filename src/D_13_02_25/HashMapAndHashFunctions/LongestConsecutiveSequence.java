package D_13_02_25.HashMapAndHashFunctions;

import java.util.*;
class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int Num = num;
                int cons = 1;
                while (set.contains(Num + 1)) {
                    Num++;
                    cons++;
                }
                longest = Math.max(longest, cons);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(arr));
    }
}
