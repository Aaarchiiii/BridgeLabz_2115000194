package D_22_01_25.Level1;

public class University {
    public static void main(String[] args){
        int fee = 125000;
        int discountPercent = 10;
        float discount = ((float)125000*10)/100f;
        float discountedFee = (float)(fee-discount);
        System.out.println("The discount amount is INR "+discount+" and final discounted fee is INR "+discountedFee);
    }
}
