package D_19_02_25.SetInterface;
import java.util.*;
public class EqualSets {
    public static <T> boolean Equals(Set<T> set1, Set<T> set2){
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Are sets equal? "+Equals(set1, set2));
    }
}
