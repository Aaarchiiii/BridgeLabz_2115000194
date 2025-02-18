package D_18_02_25;
import java.util.*;
interface Category{
    String getCategoryName();
}
class BookCategory implements Category{
    @Override
    public String getCategoryName(){
        return "Books";
    }
}
class ClothingCategory implements Category{
    @Override
    public String getCategoryName(){
        return "Clothing";
    }
}
class Product<T extends Category>{
    private String name;
    private double price;
    private T category;
    public Product(String name, double price, T category){
        this.name = name;
        this.price = price;
        this.category = category;
    }
    public String getName(){
        return name;
    }
    public double getPrice(){
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void displayProduct(){
        System.out.println("Product name: "+name+" Category: "+category.getCategoryName()+" Price: "+price);
    }
}
class MarketUtils{
    public static <T extends Product<?>> void applyDiscount(T product, double percentage){
        double discountedPrice = product.getPrice() - (product.getPrice() * (percentage/100));
        product.setPrice(discountedPrice);
        System.out.println("After discount "+product.getName()+" costs: "+discountedPrice);
    }
}
class ProductCatalog<T extends Product<?>>{
    private List<T> products = new ArrayList<>();
    public void addProduct(T product){
        products.add(product);
    }
    public void displayCatalog(){
        for(T product : products){
            product.displayProduct();
        }
    }
}
public class DynamicOnlineMarketplace {
    public static void main(String[] args){
        BookCategory bookCategory = new BookCategory();
        ClothingCategory clothingCategory = new ClothingCategory();
        Product<BookCategory> book = new Product<>("Operating System", 70, bookCategory);
        Product<ClothingCategory> cloth = new Product<>("Shirt", 100, clothingCategory);
        ProductCatalog<Product<?>> catalog = new ProductCatalog<>();
        catalog.addProduct(book);
        catalog.addProduct(cloth);
        System.out.println("Product catalog before discount");
        catalog.displayCatalog();
        MarketUtils.applyDiscount(book, 10);
        MarketUtils.applyDiscount(cloth, 20);
        System.out.println("Product catalog after discount");
        catalog.displayCatalog();
    }
}
