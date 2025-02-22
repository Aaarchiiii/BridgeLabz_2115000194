package D_22_02_25.JUnit;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class TestingListOperations {
    public static void addElement(List<Integer> list, int element) {
        list.add(element);
    }
    public static boolean removeElement(List<Integer> list, int element) {
        return list.remove(Integer.valueOf(element));
    }
    public static int getSize(List<Integer> list) {
        return list.size();
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        addElement(list, 10);
        addElement(list, 20);
        System.out.println("List after additions: " + list);
        removeElement(list, 10);
        System.out.println("List after removal: " + list);
        System.out.println("Size of list: " + getSize(list));
    }
}
class TestingListOperationsTest {
    @Test
    void testAddElement() {
        List<Integer> list = new ArrayList<>();
        TestingListOperations.addElement(list, 5);
        assertEquals(Arrays.asList(5), list);
        TestingListOperations.addElement(list, 10);
        assertEquals(Arrays.asList(5, 10), list);
    }
    @Test
    void testRemoveElement() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertTrue(TestingListOperations.removeElement(list, 2));
        assertEquals(Arrays.asList(1, 3), list);
        assertFalse(TestingListOperations.removeElement(list, 5));
    }
    @Test
    void testGetSize() {
        List<Integer> list = new ArrayList<>();
        assertEquals(0, TestingListOperations.getSize(list));
        TestingListOperations.addElement(list, 7);
        assertEquals(1, TestingListOperations.getSize(list));
        TestingListOperations.removeElement(list, 7);
        assertEquals(0, TestingListOperations.getSize(list));
    }
}
