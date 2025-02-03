package D_04_02_25;

public class Product {
    static double discount = 10;
    private String productName;
    private double price;
    private int quantity;
    final private int id;
    public Product(String productName, double price, int quantity, int id){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.id = id;
    }
    static double updateDiscount(double d){
        discount = d;
        return d;
    }
    public void Display(){
        System.out.println("Product Name: "+productName);
        System.out.println("Price: "+price);
        System.out.println("Quantity: "+quantity);
        System.out.println("Id: "+id);
    }
    public static void main(String[] args){
        Product p1 = new Product("Notebook", 50, 4, 101);
        System.out.println(p1 instanceof Product);
        p1.updateDiscount(50);
        p1.Display();
    }
}
