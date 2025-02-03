package D_04_02_25;

public class BankAccount {
    static String bankname = "HDFC";
    private String accountHolderName;
    final private double accountNumber;
    static int count = 0;
    public BankAccount(String accountHolderName, double accountNumber){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        count++;
    }
    static void getTotalAccounts(){
        System.out.println("Total number of accounts: "+count);
    }
    public void Display(){
        System.out.println("Account Holder: "+accountHolderName);
        System.out.println("Account Number: "+accountNumber);
    }
    public static void main(String[] args){
        BankAccount b = new BankAccount("Ram", 845261548);
        System.out.println(b instanceof BankAccount);
        b.getTotalAccounts();
        b.Display();
    }
}
