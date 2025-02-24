package D_24_02_25.Annotations;
import java.util.*;
public class UncheckedWarnings {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();
        list.add("Hello");
        list.add(123);
        System.out.println(list);
    }
}
