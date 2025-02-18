package D_18_02_25;
import java.util.*;
abstract class WarehouseItem{
    private String itemId;
    private String itemName;
    public WarehouseItem(String itemId, String itemName){
        this.itemId = itemId;
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }
    public abstract void displayDetails();
}
class Electronics extends WarehouseItem{
    private int warranty;
    public Electronics(String itemId, String itemName, int warranty){
        super(itemId, itemName);
        this.warranty = warranty;
    }
    @Override
    public void displayDetails() {
        System.out.println("Electronics, Id: "+getItemId()+", Name: "+getItemName()+", Warranty: "+warranty+" years");
    }
}
class Groceries extends WarehouseItem{
    private String expiryDate;
    public Groceries(String itemId, String itemName, String expiryDate){
        super(itemId, itemName);
        this.expiryDate = expiryDate;
    }
    @Override
    public void displayDetails() {
        System.out.println("Groceries, Id: "+getItemId()+", Name: "+getItemName()+", Expired on: "+expiryDate);
    }
}
class Furniture extends WarehouseItem{
    private String material;
    public Furniture(String itemId, String itemName, String material){
        super(itemId, itemName);
        this.material = material;
    }
    @Override
    public void displayDetails() {
        System.out.println("Furniture, Id: "+getItemId()+", Name: "+getItemName()+", Material used: "+material);
    }
}
class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();
    public void addItem(T item){
        items.add(item);
    }
    public List<T> getItems(){
        return items;
    }
    public void displayItems(){
        for(T item: items){
            item.displayDetails();
        }
    }
}
class WarehouseUtils{
    public static void displayAllItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            item.displayDetails();
        }
    }
}
public class SmartWarehouseManagementSystem {
    public static void main(String[] args){
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("E001", "Television", 1));
        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("G001", "Curd", "2025-02-19"));
        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("F001", "Chair", "wood"));
        System.out.println("Electronics storage");
        electronicsStorage.displayItems();
        System.out.println("Groceries storage");
        groceriesStorage.displayItems();
        System.out.println("Furniture storage");
        furnitureStorage.displayItems();
        WarehouseUtils.displayAllItems(electronicsStorage.getItems());
        WarehouseUtils.displayAllItems(groceriesStorage.getItems());
        WarehouseUtils.displayAllItems(furnitureStorage.getItems());
    }
}
