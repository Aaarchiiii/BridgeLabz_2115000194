package D_13_02_25.StacksAndQueue;

import java.util.*;
public class CircularTourProblem {
    static int startingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int total = 0;
        int current = 0;
        int start = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i); //
            total += petrol[i] - distance[i];
            current += petrol[i] - distance[i];
            while (current < 0 && !queue.isEmpty()) {
                int remove = queue.poll();
                current -= (petrol[remove] - distance[remove]);
                start = remove + 1;
            }
        }
        if (total < 0) {
            return -1;
        } else {
            return start;
        }
    }
    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        int startIndex = startingPoint(petrol, distance);
        if (startIndex == -1) {
            System.out.println("No circular tour is possible.");
        } else {
            System.out.println("Start the tour from petrol pump: " + startIndex);
        }
    }
}
