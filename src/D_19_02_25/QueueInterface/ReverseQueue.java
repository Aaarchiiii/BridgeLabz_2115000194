package D_19_02_25.QueueInterface;
import java.util.*;
public class ReverseQueue {
    public static <T> void Reverse(Queue<T> queue){
        if(queue.isEmpty()){
            return;
        }
        T front = queue.remove();
        Reverse(queue);
        queue.add(front);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        System.out.println("Original queue: "+queue);
        Reverse(queue);
        System.out.println("Reversed queue: "+queue);
    }
}
