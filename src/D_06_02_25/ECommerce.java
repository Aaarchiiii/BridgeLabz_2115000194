package D_06_02_25;
import java.util.*;
class Product {
    String productName;
    double price;
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }
    public void showDetails() {
        System.out.println("  Product: " + productName + " - Price: $" + price);
    }
}
class Order {
    String orderID;
    ArrayList<Product> products;
    public Order(String orderID) {
        this.orderID = orderID;
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public void showOrderDetails() {
        System.out.println("Order ID: " + orderID);
        double totalAmount = 0;
        for (Product product : products) {
            product.showDetails();
            totalAmount += product.price;
        }
        System.out.println("Total Amount: $" + totalAmount);
    }
}
class Customer_1 {
    String customerName;
    ArrayList<Order> orders;
    public Customer_1(String customerName) {
        this.customerName = customerName;
        this.orders = new ArrayList<>();
    }
    public void placeOrder(Order order) {
        orders.add(order);
    }
    public void showCustomerDetails() {
        System.out.println("Customer: " + customerName);
        for (Order order : orders) {
            order.showOrderDetails();
        }
    }
}
public class ECommerce {
    public static void main(String[] args) {
        Customer_1 customer = new Customer_1("Archi");
        Product product1 = new Product("Laptop", 1200.00);
        Product product2 = new Product("Smartphone", 800.00);
        Product product3 = new Product("Headphones", 150.00);
        Order order1 = new Order("ORD001");
        order1.addProduct(product1);
        order1.addProduct(product2);
        Order order2 = new Order("ORD002");
        order2.addProduct(product3);
        customer.placeOrder(order1);
        customer.placeOrder(order2);
        customer.showCustomerDetails();
    }
}
