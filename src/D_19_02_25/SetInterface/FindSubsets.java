package D_19_02_25.SetInterface;
import java.util.*;
public class FindSubsets {
    public static <T> boolean isSubset(Set<T> subset, Set<T> mainSet){
        return mainSet.containsAll(subset);
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Is set1 a subset of set2? "+isSubset(set1, set2));
    }
}
