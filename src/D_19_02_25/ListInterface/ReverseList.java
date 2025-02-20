package D_19_02_25.ListInterface;
import java.util.*;
public class ReverseList {
    public static <T> void Reverse(List<T> list){
        int left = 0;
        int right = list.size()-1;
        while(left<right){
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original array list: "+arrayList);
        Reverse(arrayList);
        System.out.println("Reversed array list: "+arrayList);

        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("Original linked list: "+linkedList);
        Reverse(linkedList);
        System.out.println("Reversed linked list: "+linkedList);
    }
}
