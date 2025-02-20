package D_19_02_25.Other;

import java.util.*;
class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
    @Override
    public String toString() {
        return "Account: " + accountNumber + " | Balance: $" + balance;
    }
}
public class BankingSystem {
    private Map<String, BankAccount> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> sortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();
    public void addAccount(String accountNumber, double balance) {
        BankAccount account = new BankAccount(accountNumber, balance);
        accounts.put(accountNumber, account);
        sortedAccounts.putIfAbsent(balance, new ArrayList<>());
        sortedAccounts.get(balance).add(accountNumber);
    }
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            BankAccount account = accounts.get(accountNumber);
            sortedAccounts.get(account.getBalance()).remove(accountNumber);
            account.deposit(amount);
            sortedAccounts.putIfAbsent(account.getBalance(), new ArrayList<>());
            sortedAccounts.get(account.getBalance()).add(accountNumber);
        }
    }
    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.add(accountNumber);
        }
    }
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            BankAccount account = accounts.get(accountNumber);
            if (account.withdraw(100)) {
                System.out.println("Withdrawal of $100 processed for " + accountNumber);
            } else {
                System.out.println("Insufficient funds for " + accountNumber);
            }
        }
    }
    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts Sorted by Balance:");
        for (Map.Entry<Double, List<String>> entry : sortedAccounts.entrySet()) {
            for (String accountNumber : entry.getValue()) {
                System.out.println(accounts.get(accountNumber));
            }
        }
    }
    public void displayAllAccounts() {
        System.out.println("\nAll Accounts:");
        for (BankAccount account : accounts.values()) {
            System.out.println(account);
        }
    }
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        bank.addAccount("ACC1001", 500.0);
        bank.addAccount("ACC1002", 1200.0);
        bank.addAccount("ACC1003", 700.0);
        bank.addAccount("ACC1004", 300.0);
        bank.displayAllAccounts();
        bank.displayAccountsSortedByBalance();
        bank.requestWithdrawal("ACC1001");
        bank.requestWithdrawal("ACC1003");
        bank.processWithdrawals();
        bank.displayAllAccounts();
    }
}
