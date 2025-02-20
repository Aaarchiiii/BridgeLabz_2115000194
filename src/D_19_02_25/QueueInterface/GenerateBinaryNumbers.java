package D_19_02_25.QueueInterface;
import java.util.*;
public class GenerateBinaryNumbers {
    public static List<String> Generate(int N){
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("1");
        for (int i=0; i<N; i++){
            String current = queue.remove();
            result.add(current);
            queue.add(current + "0");
            queue.add(current + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        System.out.println("First "+N+" Binary numbers: "+Generate(N));
    }
}
