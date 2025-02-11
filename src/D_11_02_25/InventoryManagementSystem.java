package D_11_02_25;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;
    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class Inventory {
    private Item head;
    public void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item item = new Item(itemName, itemId, quantity, price);
        item.next = head;
        head = item;
    }
    public void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item item = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = item;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = item;
    }
    public void addItemAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item item = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        for (int i = 0; i < position - 1; i++) {
            if (temp == null) {
                System.out.println("Position out of range");
                return;
            }
            temp = temp.next;
        }
        item.next = temp.next;
        temp.next = item;
    }
    public void removeItem(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            return;
        }
        Item temp = head, prev = null;
        while (temp != null && temp.itemId != itemId) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Item not found.");
            return;
        }
        prev.next = temp.next;
    }
    public void updateItemQuantity(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated successfully.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }
    public void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " ID: " + temp.itemId +
                        " Quantity: " + temp.quantity + " Price: $" + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }
    public void searchItemByName(String itemName) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equals(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " ID: " + temp.itemId +
                        " Quantity: " + temp.quantity + " Price: $" + temp.price);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item not found.");
        }
    }
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Inventory List:");
        Item temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + " ID: " + temp.itemId +
                    " Quantity: " + temp.quantity + " Price: $" + temp.price);
            temp = temp.next;
        }
    }
    public double calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        return totalValue;
    }
    private Item mergeSort(Item head, boolean sortByName, boolean ascending) {
        if (head == null || head.next == null) {
            return head;
        }
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;
        Item left = mergeSort(head, sortByName, ascending);
        Item right = mergeSort(nextOfMiddle, sortByName, ascending);
        return merge(left, right, sortByName, ascending);
    }
    private Item merge(Item left, Item right, boolean sortByName, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;
        boolean condition;
        if (sortByName) {
            condition = ascending ? left.itemName.compareTo(right.itemName) < 0 :
                    left.itemName.compareTo(right.itemName) > 0;
        } else {
            condition = ascending ? left.price < right.price : left.price > right.price;
        }
        if (condition) {
            left.next = merge(left.next, right, sortByName, ascending);
            return left;
        } else {
            right.next = merge(left, right.next, sortByName, ascending);
            return right;
        }
    }
    private Item getMiddle(Item head) {
        if (head == null) return null;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void sortInventory(boolean sortByName, boolean ascending) {
        head = mergeSort(head, sortByName, ascending);
        System.out.println("Inventory sorted successfully.");
    }
}
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtEnd("Laptop", 101, 5, 800.50);
        inventory.addItemAtEnd("Mouse", 102, 10, 25.75);
        inventory.addItemAtBeginning("Keyboard", 103, 7, 45.00);
        inventory.addItemAtPosition("Monitor", 104, 4, 120.99, 2);
        System.out.println("Inventory before sorting:");
        inventory.displayInventory();
        System.out.println("Sorting Inventory by Name (Ascending):");
        inventory.sortInventory(true, true);
        inventory.displayInventory();
        System.out.println("Total Inventory Value: $" + inventory.calculateTotalValue());
        System.out.println("Searching for Item ID 102:");
        inventory.searchItemById(102);
        System.out.println("Searching for Item Name 'Laptop':");
        inventory.searchItemByName("Laptop");
        System.out.println("Updating quantity of Item ID 101:");
        inventory.updateItemQuantity(101, 8);
        inventory.displayInventory();
        System.out.println("Removing Item ID 103:");
        inventory.removeItem(103);
        inventory.displayInventory();
    }
}
