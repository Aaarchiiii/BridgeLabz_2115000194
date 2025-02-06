package D_06_02_25;

import java.util.*;
class Account {
    private int accountNumber;
    private double balance;
    public Account(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println();
        System.out.println("Deposited: " + amount + " to Account Number: " + accountNumber);
    }
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw: " + amount + " from Account Number: " + accountNumber);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
    public double getBalance() {
        return balance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
}
class Customer {
    private String name;
    private ArrayList<Account> accounts;
    public Customer(String name) {
        this.name = name;
        accounts = new ArrayList<>();
    }
    public void openAccount(Account account) {
        accounts.add(account);
    }
    public void viewBalance() {
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Balance: " + account.getBalance());
        }
    }
    public String getName() {
        return name;
    }
}
class Bank {
    private String bankName;
    public Bank(String bankName) {
        this.bankName = bankName;
    }
    public void openAccount(Customer customer, Account account) {
        customer.openAccount(account);
        System.out.println("Account opened for " + customer.getName() + " with Account Number: " + account.getAccountNumber());
    }
    public void viewCustomerBalance(Customer customer) {
        System.out.println("Balance details for " + customer.getName() + ":");
        customer.viewBalance();
    }
}
public class BankDetails {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI Bank");
        Customer customer1 = new Customer("Archi");
        Customer customer2 = new Customer("Mayank");
        Account account1 = new Account(1, 6000);
        Account account2 = new Account(2, 8000);
        bank.openAccount(customer1, account1);
        bank.openAccount(customer2, account2);
        bank.viewCustomerBalance(customer1);
        bank.viewCustomerBalance(customer2);
        account1.deposit(3000);
        account2.withdraw(2000);
        System.out.println("\nAfter Transactions:");
        bank.viewCustomerBalance(customer1);
        bank.viewCustomerBalance(customer2);
    }
}
