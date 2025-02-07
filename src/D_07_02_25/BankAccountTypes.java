package D_07_02_25;
class BankAccount{
    private long accountNumber;
    private double balance;
    public BankAccount(long accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}
class SavingsAccount extends BankAccount{
    private double interestRate;
    public SavingsAccount(long accountNumber, double balance, double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Interest Rate: " + interestRate +"%");
    }
    public void displayAccountType(){
        System.out.println("Account Type: Savings Account");
    }
}
class CheckingAccount extends BankAccount{
    private double withdrawalLimit;
    public CheckingAccount(long accountNumber, double balance, double withdrawalLimit){
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
    public void displayAccountType(){
        System.out.println("Account Type: Checking Account");
    }
}
class FixedDepositAccount extends BankAccount{
    private String maturityDate;
    public FixedDepositAccount(long accountNumber, double balance, String maturityDate){
        super(accountNumber, balance);
        this.maturityDate = maturityDate;
    }
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Maturity Date: " + maturityDate);
    }
    public void displayAccountType(){
        System.out.println("Account Type: Fixed Deposit Account");
    }
}
public class BankAccountTypes {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(12345, 1000.0, 2.5);
        CheckingAccount checking = new CheckingAccount(87549, 1500.0, 500.0);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount(32676, 5000.0, "2026-01-01");
        savings.displayAccountType();
        savings.displayAccountInfo();
        System.out.println();
        checking.displayAccountType();
        checking.displayAccountInfo();
        System.out.println();
        fixedDeposit.displayAccountType();
        fixedDeposit.displayAccountInfo();
    }
}