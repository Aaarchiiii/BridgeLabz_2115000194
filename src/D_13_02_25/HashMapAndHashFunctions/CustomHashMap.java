package D_13_02_25.HashMapAndHashFunctions;
import java.util.*;
class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private Node<K, V>[] buckets;
    private int size;
    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;
        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    public CustomHashMap() {
        buckets = new Node[DEFAULT_CAPACITY];
        size = 0;
    }
    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }
    public void put(K key, V value) {
        int index = hash(key);
        Node<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
        size++;
    }
    public V get(K key) {
        int index = hash(key);
        Node<K, V> head = buckets[index];
        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
    public void remove(K key) {
        int index = hash(key);
        Node<K, V> head = buckets[index];
        Node<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                size--;
                return;
            }
            prev = head;
            head = head.next;
        }
    }
    public int size() {
        return size;
    }
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("Archi", 25);
        map.put("Mayank", 30);
        map.put("Khushi", 35);
        System.out.println("Archi's Age: " + map.get("Archi"));
        System.out.println("Mayank's Age: " + map.get("Mayank"));
        map.remove("Archi");
        System.out.println("Archi's Age after removal: " + map.get("Archi"));
        System.out.println("Size of HashMap: " + map.size());
    }
}

