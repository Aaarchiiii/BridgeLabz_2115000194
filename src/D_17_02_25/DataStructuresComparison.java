package D_17_02_25;

import java.util.*;
public class DataStructuresComparison {
    public static void main(String[] args) {
        int[] datasetSizes = {1000, 100000, 1000000};
        Random rand = new Random();
        for (int size : datasetSizes) {
            int[] array = new int[size];
            HashSet<Integer> hashSet = new HashSet<>();
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < size; i++) {
                int value = rand.nextInt(size * 10);
                array[i] = value;
                hashSet.add(value);
                treeSet.add(value);
            }
            int target = array[size / 2];
            long startTime = System.nanoTime();
            for (int num : array) {
                if (num == target)
                    break;
            }
            long endTime = System.nanoTime();
            long arrayTime = endTime - startTime;
            startTime = System.nanoTime();
            boolean foundInHashSet = hashSet.contains(target);
            endTime = System.nanoTime();
            long hashSetTime = endTime - startTime;
            startTime = System.nanoTime();
            boolean foundInTreeSet = treeSet.contains(target);
            endTime = System.nanoTime();
            long treeSetTime = endTime - startTime;
            System.out.println("Dataset Size: " + size);
            System.out.println("Array Search Time: " + arrayTime / 1e6 + " ms");
            System.out.println("HashSet Search Time: " + hashSetTime / 1e6 + " ms");
            System.out.println("TreeSet Search Time: " + treeSetTime / 1e6 + " ms");
        }
    }
}
