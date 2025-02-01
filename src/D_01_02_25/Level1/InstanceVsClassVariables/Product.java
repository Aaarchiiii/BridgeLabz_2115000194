package D_01_02_25.Level1.InstanceVsClassVariables;

public class Product {
    private String productName;
    private double price;
    private static int totalProducts = 0;
    public Product(){
        this.productName = "";
        this.price = 0.0;
        totalProducts++;
    }
    public Product(String productName, double price){
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    public void DisplayProductDetails(){
        System.out.println("Product Name: "+productName);
        System.out.println("Price: "+price);
    }
    public static void displayTotalProducts(){
        System.out.println("Total Products: "+totalProducts);
    }
    public static void main(String[] args){
        Product p1 = new Product();
        p1.DisplayProductDetails();
        Product p2 = new Product("Pen", 10);
        p2.DisplayProductDetails();
        Product p3 = new Product("Notebook", 40);
        p3.DisplayProductDetails();
        Product.displayTotalProducts();
    }
}
