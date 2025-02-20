package D_19_02_25.ListInterface;
import java.util.*;
public class RemoveDuplicates {
    public static <T> List<T> Remove(List<T> list){
        Set<T> visit = new HashSet<>();
        List<T> result = new ArrayList<>();
        for(T item : list){
            if(visit.add(item)){
                result.add(item);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        System.out.println("Original List: "+numbers);
        List<Integer> removed = Remove(numbers);
        System.out.println("After removing duplicates: "+removed);
    }
}
