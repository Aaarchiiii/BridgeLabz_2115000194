package D_19_02_25.ListInterface;
import java.util.*;
public class FrequencyOfElements {
    public static Map<String, Integer> count(List<String> list){
        Map<String, Integer> frequency = new HashMap<>();
        for(String item : list){
            frequency.put(item, frequency.getOrDefault(item, 0)+1);
        }
        return frequency;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "apple", "orange"));
        System.out.println("Frequency of elements: "+count(words));
    }
}
