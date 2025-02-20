package D_19_02_25.ListInterface;
import java.util.*;
public class RotateElements {
    public static <T> void Rotate(List<T> list, int positions){
        int size = list.size();
        positions = positions%size;
        List<T> rotated = new ArrayList<>(list.subList(positions, size));
        rotated.addAll(list.subList(0, positions));
        list.clear();
        list.addAll(rotated);
    }

    public static void main(String[] args) {
        List<Integer> words = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original list: "+words);
        Rotate(words, 3);
        System.out.println("Rotated list: "+words);
    }
}
