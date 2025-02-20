package D_19_02_25.ListInterface;
import java.util.*;
public class FindElement {
    public static <T> T NthFromEnd(LinkedList<T> list, int n){
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for(int i=0; i<n; i++){
            if(!first.hasNext()){
                throw new IllegalArgumentException("N is greater than the size of the list");
            }
            first.next();
        }
        while (first.hasNext()){
            first.next();
            second.next();
        }
        return second.next();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println("Nth element from end: "+NthFromEnd(list, n));
    }
}
