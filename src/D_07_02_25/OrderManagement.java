package D_07_02_25;
class Order{
    int orderId;
    String orderDate;
    public Order(int orderId, String orderDate){
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}
class ShippedOrder extends Order{
    String trackingNumber;
    public ShippedOrder(int orderId, String orderDate, String trackingNumber){
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    public String getOrderStatus() {
        return "Order shipped with tracking number " + trackingNumber;
    }
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Tracking Number: " +trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder{
    String deliveryDate;
    public DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate){
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
    public void displayOrderDetails() {
        super.displayOrderDetails();
        System.out.println("Delivery Date: " +deliveryDate);
    }
}
public class OrderManagement {
    public static void main(String[] args){
        Order order = new Order(101, "07-02-25");
        ShippedOrder shippedOrder = new ShippedOrder(102, "06-02-25", "TRK1256");
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "04-02-25", "TRK4552", "04-02-25");
        System.out.println("Order Details");
        order.displayOrderDetails();
        System.out.println("Shipped Order Details");
        shippedOrder.displayOrderDetails();
        System.out.println("Delivered Order Details");
        deliveredOrder.displayOrderDetails();
    }
}
