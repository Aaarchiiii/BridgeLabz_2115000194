package D_10_02_25;
import java.util.*;
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
    public abstract double calculateInterest();
    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: $" + balance);
    }
}
interface Loanable {
    boolean applyForLoan(double loanAmount);
    double calculateLoanEligibility();
}
class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}
class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02;
    private static final double LOAN_ELIGIBILITY_FACTOR = 5.0;
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
    public boolean applyForLoan(double loanAmount) {
        if (loanAmount <= calculateLoanEligibility()) {
            System.out.println("Loan of $" + loanAmount + " approved for " + getHolderName());
            return true;
        } else {
            System.out.println("Loan of $" + loanAmount + " denied for " + getHolderName());
            return false;
        }
    }
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_ELIGIBILITY_FACTOR;
    }
}
public class BankingSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        SavingsAccount savings = new SavingsAccount("SA123", "Archi", 5000);
        CurrentAccount current = new CurrentAccount("CA456", "Mayank", 10000);
        accounts.add(savings);
        accounts.add(current);
        for (BankAccount account : accounts) {
            account.displayDetails();
            double interest = account.calculateInterest();
            System.out.println("Annual Interest: $" + interest);
            if (account instanceof Loanable) {
                Loanable loanableAccount = (Loanable) account;
                double eligibility = loanableAccount.calculateLoanEligibility();
                System.out.println("Loan Eligibility: $" + eligibility);
                loanableAccount.applyForLoan(20000);
            }
        }
    }
}
