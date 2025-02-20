package D_19_02_25.SetInterface;
import java.util.*;
public class SetToSortedList {
    public static List<Integer> Conversion(Set<Integer> set){
        Set<Integer> sorted = new TreeSet<>(set);
        return new ArrayList<>(sorted);
    }
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(5, 3, 9, 1));
        System.out.println("Sorted List: "+Conversion(numbers));
    }
}
