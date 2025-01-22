package D_22_01_25.Level1;

import java.util.Scanner;
public class Discount {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int fee = sc.nextInt();
        int discountPercent = sc.nextInt();
        float discount = ((float)fee*discountPercent)/100f;
        float discountedFee = (float)(fee-discount);
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+discountedFee);

    }
}
