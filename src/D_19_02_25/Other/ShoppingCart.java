package D_19_02_25.Other;

import java.util.*;
public class ShoppingCart {
    private Map<String, Double> productMap = new HashMap<>();
    private Map<String, Double> orderedProductMap = new LinkedHashMap<>();
    private TreeMap<Double, List<String>> sortedProductMap = new TreeMap<>();
    public void addProduct(String product, double price) {
        productMap.put(product, price);
        orderedProductMap.put(product, price);
        sortedProductMap.putIfAbsent(price, new ArrayList<>());
        sortedProductMap.get(price).add(product);
    }
    public void displayOrderedItems() {
        System.out.println("Items in Order of Addition:");
        for (Map.Entry<String, Double> entry : orderedProductMap.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }
    public void displayItemsSortedByPrice() {
        System.out.println("Items Sorted by Price:");
        for (Map.Entry<Double, List<String>> entry : sortedProductMap.entrySet()) {
            for (String product : entry.getValue()) {
                System.out.println(product + " - $" + entry.getKey());
            }
        }
    }
    public void displayTotalPrice() {
        double total = productMap.values().stream().mapToDouble(Double::doubleValue).sum();
        System.out.println("Total Price: $" + total);
    }
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Headphones", 150.00);
        cart.addProduct("Keyboard", 100.00);
        cart.addProduct("Mouse", 50.00);
        cart.addProduct("Monitor", 300.00);
        cart.addProduct("USB Drive", 50.00);
        cart.displayOrderedItems();
        cart.displayItemsSortedByPrice();
        cart.displayTotalPrice();
    }
}
