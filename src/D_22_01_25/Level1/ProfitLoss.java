package D_22_01_25.Level1;

public class ProfitLoss {
    public static void main(String[] args){
        int costPrice = 129;
        int sellingPrice = 191;
        int profit = sellingPrice-costPrice;
        float profitPercentage = ((float)profit/costPrice)*100f;
        System.out.println("The Cost Price is INR "+costPrice+" and Selling Price is INR "+sellingPrice+ "\n" + "The Profit is INR "+profit+" and the Profit Percentage is "+profitPercentage);
    }
}
