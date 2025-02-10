package D_10_02_25;
import java.util.*;
abstract class Product{
    private String productId;
    private String name;
    private double price;
    public Product(String productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public String getProductId(){
        return productId;
    }
    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public abstract double calculateDiscount();
    public void displayDetails(){
        System.out.println("Product Id: "+productId);
        System.out.println("Product Name: "+name);
        System.out.println("Product Price: "+price);
    }
}
interface Taxable{
    double calculateTax();
    String getTaxDetails();
}
class Electronics extends Product implements Taxable{
    private static final double TAX_RATE = 0.18;
    private static final double DISCOUNT_RATE = 0.10;
    public Electronics(String productId, String name, double price){
        super(productId, name, price);
    }
    public double calculateDiscount(){
        return getPrice()*DISCOUNT_RATE;
    }
    public double calculateTax(){
        return getPrice()*TAX_RATE;
    }
    public String getTaxDetails(){
        return "Tax Rate: "+(TAX_RATE*100)+" %";
    }
}
class Clothing extends Product implements Taxable{
    private static final double TAX_RATE = 0.05;
    private static final double DISCOUNT_RATE = 0.15;
    public Clothing(String productId, String name, double price){
        super(productId, name, price);
    }
    public double calculateDiscount(){
        return getPrice()*DISCOUNT_RATE;
    }
    public double calculateTax(){
        return getPrice()*TAX_RATE;
    }
    public String getTaxDetails(){
        return "Tax Rate: "+(TAX_RATE*100)+" %";
    }
}
class Groceries extends Product implements Taxable{
    private static final double TAX_RATE = 0.02;
    private static final double DISCOUNT_RATE = 0.05;
    public Groceries(String productId, String name, double price){
        super(productId, name, price);
    }
    public double calculateDiscount(){
        return getPrice()*DISCOUNT_RATE;
    }
    public double calculateTax(){
        return getPrice()*TAX_RATE;
    }
    public String getTaxDetails(){
        return "Tax Rate: "+(TAX_RATE*100)+" %";
    }
}
public class ECommercePlatform {
    public static void main(String[] args){
        ArrayList<Product> products = new ArrayList<>();
        Electronics e = new Electronics("L102", "Laptop", 60000);
        Clothing c = new Clothing("C202", "Shirt", 500);
        Groceries g = new Groceries("G300", "Mangoes", 80);
        products.add(e);
        products.add(c);
        products.add(g);
        for(Product product:products){
            product.displayDetails();
            double discount = product.calculateDiscount();
            double tax = 0;
            if(product instanceof Taxable){
                Taxable taxable = (Taxable) product;
                tax = taxable.calculateTax();
                System.out.println(taxable.getTaxDetails());
            }
            double finalPrice = product.getPrice()+tax-discount;
            System.out.println("Discount: "+discount);
            System.out.println("Tax: "+tax);
            System.out.println("Final Price: "+finalPrice);
        }
    }
}
