package D_22_01_25.Level1;
import java.util.Scanner;
public class TotalPrice {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int unitPrice = sc.nextInt();
        int quantity = sc.nextInt();
        int totalPrice = unitPrice*quantity;
        System.out.println("The total purchase price is INR "+totalPrice+" if the quantity "+quantity+" and the unit price is INR "+unitPrice);
    }
}
