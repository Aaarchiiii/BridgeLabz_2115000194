package D_10_02_25;
import java.util.*;
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    public String getItemName() {
        return itemName;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public abstract double calculateTotalPrice();
    public void getItemDetails() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
        System.out.println("Quantity: " + quantity);
    }
}
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}
class VegItem extends FoodItem implements Discountable {
    private static final double DISCOUNT_RATE = 0.10;
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() - applyDiscount();
    }
    public double applyDiscount() {
        return getPrice() * getQuantity() * DISCOUNT_RATE;
    }
    public String getDiscountDetails() {
        return "Veg items get a " + (DISCOUNT_RATE * 100) + "% discount.";
    }
}
class NonVegItem extends FoodItem implements Discountable {
    private static final double ADDITIONAL_CHARGE = 1.50;
    private static final double DISCOUNT_RATE = 0.05;
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity() + ADDITIONAL_CHARGE * getQuantity()) - applyDiscount();
    }
    public double applyDiscount() {
        return getPrice() * getQuantity() * DISCOUNT_RATE;
    }
    public String getDiscountDetails() {
        return "Non-Veg items get a " + (DISCOUNT_RATE * 100) + "% discount.";
    }
}
public class FoodDeliverySystem {
    public static void main(String[] args) {
        ArrayList<FoodItem> order = new ArrayList<>();
        VegItem vegBurger = new VegItem("Veg Burger", 5.00, 2);
        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 12.00, 1);
        order.add(vegBurger);
        order.add(chickenPizza);
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: $" + item.calculateTotalPrice());
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                System.out.println(discountableItem.getDiscountDetails());
            }
        }
    }
}
